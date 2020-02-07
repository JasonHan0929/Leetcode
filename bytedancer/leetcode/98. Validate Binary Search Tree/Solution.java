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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //Integer太麻烦了
        return dfs(root, new Integer[]{null, null});
    }
    public boolean dfs(TreeNode root, Integer[] minMax) {
        if (root.left == null && root.right == null) {
            minMax[0] = root.val;
            minMax[1] = root.val;
            return true;
        }
        Integer[] leftMinMax = new Integer[]{null, null};
        Integer[] rightMinMax = new Integer[]{null, null};
        if (root.left != null && !dfs(root.left, leftMinMax)) {
            return false;
        }
        if (root.right != null && !dfs(root.right, rightMinMax)) {
            return false;
        }
        if (leftMinMax[1] != null && leftMinMax[1] >= root.val || rightMinMax[0] != null && rightMinMax[0] <= root.val) {
            return false;
        }
        minMax[0] = getMin(leftMinMax[0], root.val, rightMinMax[0]);
        minMax[1] = getMax(leftMinMax[1], root.val, rightMinMax[1]);
        //System.out.printf("%s, %s\n", root.val, Arrays.toString(minMax))
        return true;
    }
    private Integer getMin(Integer... args) {
        Integer min = null;
        for (Integer arg : args) {
            if (arg == null) {
                continue;
            }
            if (min == null) {
                min = arg;
                continue;
            }
            min = Math.min(min, arg);
        }
        return min;
    }
    private Integer getMax(Integer... args) {
        Integer max = null;
        for (Integer arg : args) {
            if (arg == null) {
                continue;
            }
            if (max == null) {
                max = arg;
                continue;
            }
            max = Math.max(max, arg);
        }
        return max;
    }
}
