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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null)
            return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            double sum = 0;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                cur = queue.poll();
                sum += cur.val;
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            result.add(sum / count);
        }
        return result;
    }
}

/*
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        // list answer for sum all value in same level
        List<Double> answer = new ArrayList<Double>();
        
        // list counter for count number of node in same level
        List<Integer> counter = new ArrayList<Integer>();
        
        // using dfs to sum all value in same level and count number of node in same level
        dfs(0, root, answer, counter);
        
        // answer will be answer[level] / counter[level]
        for (int level = 0; level < answer.size(); level++) {
            answer.set(level, answer.get(level) / counter.get(level));
        }
        return answer;
    }

    public void dfs(int level, TreeNode node, List<Double> answer, List<Integer> counter) {
        if (node == null) {
            return;
        }

        if (answer.size() <= level) {
            answer.add(0.0);
            counter.add(0);
        }

        answer.set(level, answer.get(level) + node.val);
        counter.set(level, counter.get(level) + 1);

        // go left node and right node
        dfs(level + 1, node.left, answer, counter);
        dfs(level + 1, node.right, answer, counter);
    }
}//dfs
*/
