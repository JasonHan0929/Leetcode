public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtracing(result, new LinkedList<>(), nums);
        return result;
    }
    public void backtracing(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new LinkedList<>(temp));//不要能add(temp)，一定要新建一个copy
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (!temp.contains(nums[i])) {
                    temp.add(nums[i]);
                    backtracing(result, temp, nums);
                    temp.remove(temp.size() - 1);//什么时候回溯呢？每次backtracing弹回的时候，应该回到上一步的状态
                }
            }
        }
    }
}//回溯法，请用其他相关题目继续理解和研究
