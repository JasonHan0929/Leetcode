class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length() && p.charAt(i) == '*'; i++) {
            dp[0][i + 1] = true;
        } //这坨初始化别忘了
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) <= 'z' && p.charAt(j - 1) >= 'a') {
                    dp[i][j] = dp[i - 1][j - 1] && match(i - 1, j - 1, s, p); 
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    private boolean match(int i, int j, String s, String p) {
        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '?';
    }
}
