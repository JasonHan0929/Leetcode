public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int left = 1;
        int right = nums.length - 1;
        int distance = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            left = i + 1;
            right = nums.length - 1;
            while (right > left) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == target)
                    return sum;
                if (Math.abs(sum - target) < distance) {
                    result = sum;
                    distance = Math.abs(sum - target);
                }
                if (sum < target) {
                    left++;
                    while (left <= right && nums[left - 1] == nums[left]) //注意要完整扫一遍
                    left++;
                }
                else if (sum > target) {
                    right--;
                    while (right >= left && nums[right] == nums[right + 1]) //注意循环条件
                        right--;
                }
            }
        }
        return result;
    }
}
