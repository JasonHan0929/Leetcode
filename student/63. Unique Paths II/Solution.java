public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] grid = new int[m][n];
        grid[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0)
                grid[i][0] = grid[i - 1][0];// be careful that values could not simply be initialized with 1 for the testcase [[1, 0]]
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0)
                grid[0][j] = grid[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[m - 1][n - 1];
    }
}
