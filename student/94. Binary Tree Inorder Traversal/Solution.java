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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        /*if (root.right == null && root.left == null) {
            result.add(root.val);
            return result;
        }冗余代码*/
        //if (root.left != null) {
            result.addAll(inorderTraversal(root.left));
        //}
        result.add(root.val);
        //if (root.right != null){
            result.addAll(inorderTraversal(root.right));
        //}
        return result;
    }
}
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pollLast();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}//迭代版，注意循环的控制
