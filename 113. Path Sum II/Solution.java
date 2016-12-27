public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(root, sum, 0, result, new LinkedList<Integer>());
        return result;
    }
    public void dfs(TreeNode root, int target, int sum, List<List<Integer>> result, LinkedList<Integer> path) {//可以将target 和 sum合并，即每次递归target - cur.val
        if (root != null) {
            if (root.val + sum == target && root.left == null && root.right == null) {
                path.add(root.val);
                result.add(new LinkedList<Integer>(path));//注意不能用add(path)因为path是引用每次都会被修改，最终只有[]
                path.removeLast();//注意两个情况最后都要修正path
            }
            else {//不能是else if (root.val + sum < target)因为val和target可能有负数;也不能是root.val + sum != target可能存在想等但是还没到叶子节点的情况，总之就是没有找到一条符合target的路径就应该不停的递归
                path.add(root.val);
                dfs(root.left, target, sum + root.val, result, path);
                dfs(root.right, target, sum + root.val, result, path);
                path.removeLast();
            }
        }
    }
}//递归版
