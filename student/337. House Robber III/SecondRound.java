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
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }
    
    public int[] dfs(TreeNode root) { // [include, notInclude]
        if (root == null) return new int[]{0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        return new int[]{root.val + left[1] + right[1], Math.max(right[0], right[1]) + Math.max(left[1], left[0])};// pay attention to return[1]
    }
}
