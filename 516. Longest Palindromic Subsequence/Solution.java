public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (i - j >= 2) {
                    if (s.charAt(i) == s.charAt(j))
                        dp[j][i] = dp[j + 1][i - 1] + 2;
                    else
                        dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                }
                else if (i - j == 1)
                    dp[j][i] = (s.charAt(i) == s.charAt(j) ? 2 : 1);
                else
                    dp[j][i] = 1;
            }
        }
        return dp[0][n - 1];
    }
}

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j))
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                else
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
            }
        }
        return dp[0][n - 1];
    }
}//more concise, no need to check i - j