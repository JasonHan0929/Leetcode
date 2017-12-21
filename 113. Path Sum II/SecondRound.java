/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            dfs(result, root, sum, new ArrayList<>());
        }
        return result;
    }
    public void dfs(List<List<Integer>> result, TreeNode root, int sum, List<Integer> temp) {
        temp.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>(temp));
        }
        if (root.left != null) {
            dfs(result, root.left, sum - root.val, temp);
        }
        if (root.right != null) {
            dfs(result, root.right, sum - root.val, temp);
        }
        temp.remove(temp.size() - 1); // temp.removeLast()
    }
}
