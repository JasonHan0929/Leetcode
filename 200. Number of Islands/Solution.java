public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m,n);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = 'x';
            dfs(grid, i, j + 1, m, n);
            dfs(grid, i, j - 1, m, n);
            dfs(grid, i - 1, j, m, n);
            dfs(grid, i + 1, j, m, n);
        }
    }
}//dfs
