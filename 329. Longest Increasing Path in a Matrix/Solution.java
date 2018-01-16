class Solution {
    
    private final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dfs(i, j, m, n, dp, matrix), max);
            }
        }   
        return max;
    }
    public int dfs(int i, int j, int m, int n, int[][] dp, int[][] matrix) {
        if (dp[i][j] > 0) return dp[i][j];
        int len = 1;
        for (int[] direct : directions) {
            int x = i + direct[0], y = j + direct[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            len = Math.max(len, 1 + dfs(x, y, m, n, dp, matrix));
        }
        dp[i][j] = len;
        return len;
    }
}

/*
the DFS here is basically like DP with memorization. Every cell that has been computed will not be computed again, only a value look-up is performed. So this is O(mn), m and n being the width and height of the matrix.
To be exact, each cell can be accessed 5 times at most: 4 times from the top, bottom, left and right and one time from the outermost double for loop. 4 of these 5 visits will be look-ups except for the first one. So the running time should be lowercase o(5mn), which is of course O(mn).
*/
