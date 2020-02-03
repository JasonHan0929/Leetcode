/*public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(board, visited, i, 0, false);
            dfs(board, visited, i, n-1, false);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, visited, 0, j, false);
            dfs(board, visited, m-1, j, false);
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++)
                dfs(board, visited, i, j, true);
        }
    }
    public void dfs(char[][]board, boolean[][] visited, int i, int j, boolean flip) {
        if (!visited[i][j] && board[i][j] == 'O') {
            visited[i][j] = true;
            if (flip)
                board[i][j] = 'X';
            if (i - 1 > 0)
                dfs(board, visited, i-1, j, flip);
            if (j - 1 > 0)
                dfs(board, visited, i, j-1, flip);
            if (i + 1 < visited.length)
                dfs(board, visited, i+1, j, flip);
            if (j + 1 < visited[0].length)
                dfs(board, visited, i, j+1, flip);
        }
    }
}*/ // stack overflow

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][n - 1] == 'O')
                dfs(board, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);
            if (board[m - 1][j] == 'O')
                dfs(board, m-1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';// no need to use dfs
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
        }
    }
    public void dfs(char[][]board, int i, int j) {
        board[i][j] = '*';
        if (i - 1 > 0 && board[i - 1][j] == 'O')
            dfs(board, i-1, j);
        if (j - 1 > 0 && board[i][j - 1] == 'O')
            dfs(board, i, j-1);
        if(i + 1 < board.length -1 && board[i + 1][j] == 'O')
            dfs(board, i+1, j);
        if (j + 1 < board[0].length - 1 && board[i][j + 1] == 'O')
            dfs(board, i, j+1);
    }
}
