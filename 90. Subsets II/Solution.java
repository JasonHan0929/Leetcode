public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new LinkedList<Integer>());//remember the []
        dfs(nums, result, new LinkedList<Integer>(), 0);
        return result;
    }
    public void dfs(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i])//same value could not appear in one node twice
                continue;
            temp.add(nums[i]);
            result.add(new LinkedList<>(temp));
            dfs(nums, result, temp, i + 1);//using start is because the value once appeared in former node, could never appear in the next node, so you don't need a vistied[] but a index of start
            temp.remove(temp.size() - 1);
        }
    }
}//not very fast but a standard solution


public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> each = new ArrayList<>();
        helper(res, each, 0, nums);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
        if (pos <= n.length) {
            res.add(each);
        }
        int i = pos;
        while (i < n.length) {
            each.add(n[i]);
            helper(res, new ArrayList<>(each), i + 1, n);
            each.remove(each.size() - 1);
            i++;
            while (i < n.length && n[i] == n[i - 1]) {i++;}//the reason why this solution is faster?
        }
        return;
    }
}
