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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null || !deque.isEmpty()) {
            while (cur != null) {
                deque.add(cur);
                cur = cur.left;
            }
            cur = deque.pollLast();
            k--;
            if (k == 0)
                break;
            cur = cur.right;
        }
        return cur.val;
    }
}
