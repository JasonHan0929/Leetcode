class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                int former = dp[j] == -1 ? Integer.MAX_VALUE : dp[j];
                int curr = dp[j - coins[i]] == -1 ? Integer.MAX_VALUE : dp[j - coins[i]] + 1;
                dp[j] = Math.min(former, curr);
                if (dp[j] == Integer.MAX_VALUE) dp[j] = -1;
            }
        }
        return dp[amount];
    }
}
