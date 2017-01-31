public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return result;
        dfs(result, new LinkedList<>(), nums, 0);
        return result;
    }
    public void dfs(List<List<Integer>> result, List<Integer> sequence, int[] nums, int start) {
        int size = sequence.size();
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!sequence.isEmpty() && nums[i] < sequence.get(sequence.size() - 1))
                continue;
            if (!set.add(nums[i]))
                continue;
            sequence.add(nums[i]);
            if (sequence.size() != size && sequence.size() > 1)
                result.add(new ArrayList(sequence));
            dfs(result, sequence, nums, i + 1);
            if (sequence.size() != size)
                sequence.remove(sequence.size() - 1);
        }
    }
}//backtracing
