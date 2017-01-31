public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (S < -sum || S > sum)
            return 0;
        int n = nums.length;
        int[][] dp = new int[sum * 2 + 1][n + 1];
        dp[sum][0] = 1;//pay attention to the initialization
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                if (j + nums[i - 1] <= 2 * sum)
                    dp[j][i] += dp[j + nums[i - 1]][i - 1];
                if (j - nums[i - 1] >= 0)
                    dp[j][i] += dp[j - nums[i - 1]][i - 1];
            }
        }
        return dp[sum + S][n];
    }
}//similar to knapsack problem without repetition

public class Solution {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0; 
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+s];
    }
}//could compact into an one-dimention array
