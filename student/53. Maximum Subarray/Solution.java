public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = 0;// result should be initialized with 0 which means the sum of an empty subset
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}//Kadane's algorithm
