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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        dfs_left(root, root, result);
        dfs_leaf(root, result);
        dfs_right(root, root, result);
        return result;
    }
    
    public void dfs_left(TreeNode realRoot, TreeNode root, List<Integer> result) {
        if (root.left == null && root.right == null) return;
        result.add(root.val);
        if (root.left != null) dfs_left(realRoot, root.left, result);
        else if (root != realRoot) dfs_left(realRoot, root.right, result);
    }
    
    public void dfs_leaf(TreeNode root, List<Integer> result) {
        if (root.left == null && root.right == null) result.add(root.val);
        if (root.left != null) dfs_leaf(root.left, result);
        if (root.right != null) dfs_leaf(root.right, result);
    }
    
    public void dfs_right(TreeNode realRoot, TreeNode root, List<Integer> result) {
        if (root.left == null && root.right == null) return;
        if (root.right != null) dfs_right(realRoot, root.right, result);
        else if (root != realRoot) dfs_right(realRoot, root.left, result);
        if (root != realRoot) result.add(root.val); // do not duplicate the root node
    }
} 
