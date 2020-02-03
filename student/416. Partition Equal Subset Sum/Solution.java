public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            boolean[] next = new boolean[sum / 2 + 1];
            for (int j = 0; j <= sum / 2; j++) {
                if (j + nums[i] <= sum / 2 && dp[j]) {
                    next[j + nums[i]] = true;
                    next[j] = true;
                }
            }
            dp = next;
            if (dp[sum / 2])
                return true;
        }
        return false;
    }
}//compress to one-dimention array
