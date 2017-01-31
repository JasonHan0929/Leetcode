public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length == 1)
            return true;
        int n = nums.length;
        int[][] dp = new int[n][n];
        int[][] sum = new int[n][n];
        for (int i = 0 ; i < n; i++) {
            dp[i][i] = nums[i];
            sum[i][i] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sum[i][j] =  sum[i][j - 1] + nums[j];
            }
        }

        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = Math.max(sum[j][j + i] - dp[j + 1][j + i], sum[j][j + i] - dp[j][j+ i - 1]);
            }
        }
        return sum[0][n - 1] - dp[0][n - 1] <= dp[0][n - 1];
    }
}//sum[i][j] = sum[j] - sum[i] + nums[i] so only need one-dimention array to store sum
/*
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1)>=0;
    }
    private int helper(int[] nums, int s, int e){        
        return s==e ? nums[e] : Math.max(nums[e] - helper(nums, s, e-1), nums[s] - helper(nums, s+1, e));
    }
}
Inspired by @sameer13, add a cache:

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1, new Integer[nums.length][nums.length])>=0;
    }
    private int helper(int[] nums, int s, int e, Integer[][] mem){    
        if(mem[s][e]==null)
            mem[s][e] = s==e ? nums[e] : Math.max(nums[e]-helper(nums,s,e-1,mem),nums[s]-helper(nums,s+1,e,mem));
        return mem[s][e];
    }
}
*/
