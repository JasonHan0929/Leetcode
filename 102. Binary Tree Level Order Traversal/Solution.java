public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        bfs(root, result);
        return result;
    }
    public void bfs(TreeNode root, List<List<Integer>> result) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelNodes = 0;
        List<Integer> level;
        TreeNode cur;
        while (queue.size() > 0) {
            levelNodes = queue.size();
            level = new LinkedList<>();
            for (int i = 0; i < levelNodes; i ++) {
                cur = queue.poll();
                if (cur != null) {
                    level.add(cur.val);
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            if (level.size() > 0)
                result.add(level);
        }
    }
}//bfs版，dfs也可以做，进阶版107. Binary Tree Level Order Traversal II
