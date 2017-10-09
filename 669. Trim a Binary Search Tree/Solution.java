/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return dfs(root, L, R);
    }
    public TreeNode dfs(TreeNode root, int L, int R) {
        if (root == null)
            return null;
        if (root.val <= R && root.val >= L) {
            root.left = dfs(root.left,L ,R);
            root.right = dfs(root.right, L, R);
            return root;
        } else if (root.val < L)
            return dfs(root.right, L, R);
        else
            return dfs(root.left, L, R);
    }
}

/*
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        
        return root;
    }
}
*/
