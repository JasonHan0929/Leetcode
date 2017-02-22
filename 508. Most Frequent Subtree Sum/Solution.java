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
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        dfs(root, hash);
        int maxFrequence = -1;
        int count = 0;
        for (int fre : hash.values()) {
            if (fre > maxFrequence) {
                count = 1;
                maxFrequence = fre;
            }
            else if (fre == maxFrequence)
                count++;
        }
        int[] result = new int[count];
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            if (entry.getValue() == maxFrequence)
                result[count-- - 1] = entry.getKey();
        }
        return result;
    }
    public int dfs(TreeNode root, HashMap<Integer, Integer> hash) {
        if (root == null)
            return 0;
        int left = dfs(root.left, hash);
        int right = dfs(root.right, hash);
        int sum = left + right + root.val;
        hash.put(sum, hash.getOrDefault(sum, 0) + 1);
        return sum;
    }
}/*
public class Solution {
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        List<Integer> res = new LinkedList<>();
        for(Map.Entry<Integer, Integer> me: map.entrySet()){
            if(me.getValue()==max) res.add(me.getKey());
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    
    private int helper(TreeNode n, Map<Integer, Integer> map){
        int left = (n.left==null) ? 0 : helper(n.left, map);
        int right = (n.right==null) ? 0 : helper(n.right, map);
        int sum = left + right + n.val;
        map.put(sum, map.getOrDefault(sum,0)+1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}
*/
