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
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root) {
        int count = 1, left = 0, right = 0;
        if (root.left != null) {
            if (root.left.val == root.val)
                left = dfs(root.left);
            else
                dfs(root.left);
        }
        if (root.right != null) {
            if (root.right != null) {
                if (root.right.val == root.val)
                    right = dfs(root.right);
                else
                    dfs(root.right);
            }
        }
        max = Math.max(max, count + left + right - 1);// return value and max value are not same
        count = count + Math.max(left, right);
        return count;
    }
}

/*
int len = 0; // global variable
public int longestUnivaluePath(TreeNode root) {
    if (root == null) return 0;
    len = 0;
    getLen(root, root.val);
    return len;
}

private int getLen(TreeNode node, int val) {
    if (node == null) return 0;
    int left = getLen(node.left, node.val);
    int right = getLen(node.right, node.val);
    len = Math.max(len, left + right);
    if (val == node.val)  return Math.max(left, right) + 1;
    return 0;
}
*/
