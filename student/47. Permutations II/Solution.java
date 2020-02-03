public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);//主要要靠排序来剔除重复情况
        backtracing(list, new LinkedList<Integer>(), nums, new boolean[nums.length]);
        return list;
    }
    public void backtracing(List<List<Integer>> result, List<Integer> temp ,int[] nums, boolean marks[]) {
        if (temp.size() == nums.length)
            result.add(new LinkedList<>(temp));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (marks[i] || i > 0 && nums[i] == nums[i - 1] && marks[i - 1])//注意如何剔除重复排列，marks[i - 1]的判断
                    continue;
                else {
                    temp.add(nums[i]);
                    marks[i] = true;
                    backtracing(result, temp, nums, marks);
                    temp.remove(temp.size() - 1);
                    marks[i] = false;
                }
            }
        }
    }
}
