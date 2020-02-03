public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        else if (nums.length == 1) {
            return nums[0];
        }//两种边界情况
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);//注意初始化的值，dp[1]可以不被初始化吗？
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int result = 0;
        for (int num : dp) {
            result = Math.max(result, num);
        }
        return result;
    }
}
/*
动态规划（Dynamic Programming）

状态转移方程：

dp[i] = max(dp[i - 1], dp[i - 2] + num[i - 1])

其中，dp[i]表示打劫到第i间房屋时累计取得的金钱最大值。

时间复杂度O(n)，空间复杂度O(n)
*/

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        else if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        int max = dp[1];//注意max的起始值不是0
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}//减去空间开销
