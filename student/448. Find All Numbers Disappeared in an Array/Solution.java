public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        for (int j = 0; j < nums.length; j++) {
            if (nums[Math.abs(nums[j]) - 1] > 0 )
                nums[Math.abs(nums[j]) - 1] = -nums[Math.abs(nums[j]) - 1]; // nums[Math.abs(nums[j]) - 1] = -Maht.abs(nums[Math.abs(nums[j]) - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                result.add(i + 1);
        }
        return result;
    }
}
