/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<TreeNode>();// pay attention to this corner case
        return recursion(1, n);
    }
    public List<TreeNode> recursion(int low, int high) {
        List<TreeNode> list = new LinkedList<>();
        if (low > high)
            list.add(null);
        for (int i = low; i <= high; i++) {
            List<TreeNode> lefts = recursion(low, i -1);
            List<TreeNode> rights = recursion(i + 1, high);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);// for value i, there may be many sub BST so you should return an list rather than only one TreeNode
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
