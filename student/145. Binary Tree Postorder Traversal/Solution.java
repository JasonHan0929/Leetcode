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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }
}//低端low B递归法

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode lastNode = null;
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.peek();
                if (root.right != null && lastNode != root.right)
                    root = root.right;
                else {//没有右节点或者右节点已经被访问过了
                    result.add(root.val);
                    lastNode = stack.pop();
                    root = null;//注意这一步是为了让node可以不断回弹，wiki上伪代码没写
                }
            }
        }
        return result;
    }
}//wiki伪代码，标记法
