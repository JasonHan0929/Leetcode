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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        if (cur != null)
            stack.add(cur);
        while (!stack.isEmpty()) {
            cur = stack.pollLast();
            result.add(cur.val);
            if (cur.right != null)
                stack.add(cur.right);
            if (cur.left != null)
                stack.add(cur.left);
        }
        return result;
    }
}// 用deque，deque内不能有null

public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        if (node != null) {
            result.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
    }
    return result;
}//用stack，可以有null

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
    public void traversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            if (root.left != null)
                traversal(root.left, result);
            if (root.right != null)
                traversal(root.right, result);
        }
    }
}//迭代版，注意和中序遍历模式不一样，需要辅助一函数traversal
