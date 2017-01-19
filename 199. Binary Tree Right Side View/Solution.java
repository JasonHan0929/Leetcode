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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result, 0, -1);
        return result;
    }
    public int dfs(TreeNode root, List<Integer> result, int level, int maxLevel) {
        if (root == null)
            return maxLevel;
        if (level > maxLevel) {
            result.add(root.val);
            maxLevel = level;
        }
        maxLevel = dfs(root.right, result, level + 1, maxLevel);
        maxLevel = dfs(root.left, result, level + 1, maxLevel);//pay attention to that if not return maxLevel here the value of maxLevel in the left subtree whill not be correct.
        return maxLevel;
    }
}// BFS could also solve this problem easily. Just add every last element of every level into the result list.
