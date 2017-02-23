public class Solution {
    public int countBattleships(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    dfs(board, i , j);
                    result++;
                }
            }
        }
        return result;
    }
    public void dfs(char[][] board, int i, int j) {
        board[i][j] = '.';
        if (i > 0 && board[i - 1][j] == 'X')
            dfs(board, i - 1, j);
        else if (j > 0 && board[i][j - 1] == 'X')
            dfs(board, i, j - 1);
        else if (j < board[0].length -1 && board[i][j + 1] == 'X')
            dfs(board, i, j + 1);
        else if (i < board.length - 1 && board[i + 1][j] == 'X')
            dfs(board, i + 1, j);
    }
}//dfs and the array has to be modified

public class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m==0) return 0;
        int n = board[0].length;
        
        int count=0;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') continue;
                if (j > 0 && board[i][j-1] == 'X') continue;
                count++;
            }
        }
        
        return count;
    }
}//use the sequence of the loop