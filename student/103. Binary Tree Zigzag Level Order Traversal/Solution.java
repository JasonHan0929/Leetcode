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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        TreeNode curr;
        boolean fromLeft = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new LinkedList<>();
            while (size-- > 0) {
                curr = deque.poll();
                if (fromLeft)
                    level.add(curr.val);
                else
                    level.add(0, curr.val);
                if (curr.left != null)
                    deque.offer(curr.left);
                if (curr.right != null)
                    deque.offer(curr.right);
            }
            result.add(level);
            fromLeft = !fromLeft;
        }
        return result;
    }
}
