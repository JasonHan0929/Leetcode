/*
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1];
                }
                if (i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
*/

/*
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] cur = new int[n];
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cur[j] = pre[j];
                if (j - 1 >= 0) {
                    cur[j] += cur[j - 1];
                }
            }
            int[] temp = pre;
            pre = cur;
            cur = temp;
        }
        return pre[n - 1];
    }
}
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] cur = new int[n];
        cur[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j - 1 >= 0) {
                    cur[j] += cur[j - 1];
                }
            }
        }
        return cur[n - 1];
    }
}
