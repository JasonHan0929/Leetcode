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
    public int findBottomLeftValue(TreeNode root) {
        int[] result = dfs(root, 0);
        return result[1];
    }
    public int[] dfs(TreeNode root, int level) {
        if (root == null)
            return new int[]{-1, -1};
        level++;
        int[] left = dfs(root.left, level);
        int[] right = dfs(root.right, level);
        if (left[0] == -1 && right[0] == -1)
            return new int[]{level, root.val};
        else
            return right[0] > left[0] ? right : left;
    }
}//DFS, fast

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        stack.push(root);
        int result = -1;
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                curr = stack.poll();
                if (i == 0)
                    result = curr.val;
                if (curr.left != null)
                    stack.offer(curr.left);
                if (curr.right != null)
                    stack.offer(curr.right);
            }
        }
        return result;
    }
}//BFS, slow
