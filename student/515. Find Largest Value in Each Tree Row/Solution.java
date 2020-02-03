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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
    public void dfs(TreeNode root, int level, List<Integer> result) {
        if (root == null)
            return;
        if (result.size() <= level)
            result.add(root.val);
        else
            result.set(level, Math.max(root.val, result.get(level)));
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }
}//dfs, could also easily use bfs