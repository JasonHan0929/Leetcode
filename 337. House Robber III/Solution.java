/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*public class Solution {
    public int rob(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> dp = new ArrayList<>();
        if (root == null) return 0;
        queue.offer(root);
        TreeNode cur;
        int level = 0;
        while (queue.size() > 0) {
            int levelNodes = queue.size();
            int sum = 0;
            for (int i = 0; i < levelNodes; i++) {
                cur = queue.poll();
                if (cur != null) {
                    sum += cur.val;
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            if (level >= 2) {
                dp.add(level, Math.max(dp.get(level - 1), dp.get(level - 2) + sum));
            }
            else if (level == 0) {
                dp.add(level, sum);
            }
            else { //level == 1
                dp.add(level, Math.max(sum, dp.get(0)));
            }
            level++;
        }
        int max = 0;
        for (int num : dp) {
            max = Math.max(num, max);
        }
        return max;
    }
}*/ //wrong answer
public class Solution {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }
    public int[] dfs(TreeNode root) {
        if (root == null)
            return new int[2];
        int[] right = dfs(root.left);
        int[] left = dfs(root.right);
        int[] result = new int[2]; // result[0] for the maximum value while robing this node, result[1] for the maximum value not robing this node
        result[1] = Math.max(right[0], right[1]) + Math.max(left[0], left[1]);// pay attention
        result[0] = right[1] + left[1] + root.val;
        return result;
    }
}//figure out which kind of values should be needed as return value
