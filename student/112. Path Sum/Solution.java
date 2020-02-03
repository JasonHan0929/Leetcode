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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        int s = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();//注意每次回弹到上一级节点s都要回复到之前的样子，所以需要两个栈
        stack.push(root);
        sumStack.push(root.val);
        while (!stack.empty()) {
            root = stack.pop();
            s = sumStack.pop();
            if (root .left == null && root.right == null) {
                if (sum == s)
                    return true;
                continue;
            }
            if (root.right != null) {
                stack.push(root.right);
                sumStack.push(s + root.right.val);
            }
            if (root.left != null) {
                stack.push(root.left);
                sumStack.push(s + root.left.val);
            }
        }
        return false;
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            if (sum == root.val)
                return true;//注意每次return的都是该层递归函数自己的值，所以上一级函数必须承接这个值否则结果传不回最初的函数
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val); //很简便的写法
    }
}
