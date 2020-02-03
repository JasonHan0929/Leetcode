class Solution {
    public static int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int m = M.length, n = M[0].length;
        int[][] dp = new int[n][4];
        int result = 0;
        for (int i = 0; i < m; i++) {
            int[][] next = new int[n][4];
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) {
                    continue;
                }
                next[j][0] = (j -1 >= 0 ? next[j - 1][0] : 0) + 1; // row
                next[j][1] = dp[j][1] + 1; // column
                next[j][2] = (j - 1 >= 0 ? dp[j - 1][2] : 0) + 1; // diagonal
                next[j][3] = (j + 1 < n ? dp[j + 1][3] : 0) + 1;
                for (int k = 0; k < 4; k++) {
                    result = Math.max(result, next[j][k]);
                }
            }
            dp = next;
        }
        return result;
    }
}

/*
class Solution {
    public int longestLine(int[][] M) {
        int result = 0;
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int[][][] record = new int[2][M[0].length + 2][4];
        for (int i = 1; i <= M.length; i++) {
            for (int j = 1; j <= M[0].length; j++) {
                if (M[i - 1][j - 1] == 1) {
                    record[i%2][j][0] = record[(i - 1) % 2][j][0] + 1;     
                    record[i%2][j][1] = record[i % 2][j - 1][1] + 1;
                    record[i%2][j][2] = record[(i - 1) % 2][j - 1][2] + 1;
                    record[i%2][j][3] = record[(i - 1) % 2][j + 1][3] + 1;
                    for (int k = 0; k < 4; k++) {
                        result = Math.max(result, record[i % 2][j][k]);
                    }
                } else {
                    for (int k = 0; k < 4; k++) {
                        record[i%2][j][k] = 0;
                    }
                }
            }
        }
        return result;
    }
}
*/
