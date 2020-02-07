class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (i - 1 >= 0 && s.charAt(i - 1) == '(') {
                    dp[i] += 2;
                    if (i - 2 >= 0) {
                        dp[i] += dp[i - 2];
                    }
                } else {
                    //有点恶心的脚⌚️判断
                    if (i - 1 >= 0 && (i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] += dp[i - 1] + 2;
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] += dp[i - dp[i - 1] -2];
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
