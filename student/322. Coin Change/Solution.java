public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0)
            return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int num : coins) {
                if (i - num >= 0 && dp[i - num] != Integer.MAX_VALUE)//pay attention to the last restraint which to prevent overflow
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
