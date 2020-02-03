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
    public int pathSum(TreeNode root, int sum) {
        int result = 0;
        if (root != null) {
            result += dfs(root, sum, 0);
            result += pathSum(root.left, sum);
            result += pathSum(root.right, sum);
        }
        return result;
    }
    public int dfs(TreeNode root, int sum, int count) {
        if (root != null) {
            if (root.val == sum)
                count++;
            count = dfs(root.left, sum - root.val, count);
            count = dfs(root.right, sum - root.val, count);
        }
        return count;
    }
}//以每个节点为根便利寻找目标路径，O(n^2)时间复杂度,注意端点不是leaf或者root的路径不会存在重复算两次的情况

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  //Default sum = 0 has one count
        return backtrack(root, 0, sum, map); 
    }
    //BackTrack one pass
    public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map){
        if(root == null)
            return 0;
        sum += root.val;
        int res = map.getOrDefault(sum - target, 0);    //See if there is a subarray sum equals to target
        map.put(sum, map.getOrDefault(sum, 0)+1);
        //Extend to left and right child
        res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
        map.put(sum, map.get(sum)-1);   //Remove the current node so it wont affect other path
        return res;
    }
}//牛B解法
