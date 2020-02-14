class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null && s2 == null || s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        boolean[][][] dp = new boolean[s1.length()][s2.length()][s1.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int k = 2; k <= s1.length(); k++) {
            for (int i = 0; i <= s1.length() - k; i++) {
                for (int j = 0; j <= s2.length() - k; j++) {
                    for (int w = 1; w <= k - 1; w++) { // 一堆边界要讨论清楚
                        dp[i][j][k] = dp[i][j][w] && dp[i+w][j+w][k - w] || dp[i][j+k-w][w] && dp[i+w][j][k-w];
                        if (dp[i][j][k]) {
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][s1.length()];
    }
}
