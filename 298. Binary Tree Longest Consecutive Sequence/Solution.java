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
    
    int max = 1;
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        int left = 1, right = 1;
        if (root.left != null) {
            int temp = dfs(root.left);
            if (root.val == root.left.val - 1) left += temp;
        }
        if (root.right != null) {
            int temp = dfs(root.right);
            if (root.val == root.right.val - 1) right += temp;
        }
        int result = Math.max(left, right);
        max = Math.max(max, result);
        return result;
    }
}
/*
public class Solution {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0, root.val);
        return max;
    }
    
    public void helper(TreeNode root, int cur, int target){
        if(root == null) return;
        if(root.val == target) cur++;
        else cur = 1;
        max = Math.max(cur, max);
        helper(root.left, cur, root.val + 1);
        helper(root.right, cur, root.val + 1);
    }
}
*/
