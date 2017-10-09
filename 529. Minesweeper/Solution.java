class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int rows = board.length, columns = board[0].length;
        int[][] revealed = new int[rows + 2][columns + 2];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (board[i - 1][j - 1] == 'M') {
                    revealed[i - 1][j - 1] += 1;
                    revealed[i - 1][j] += 1;
                    revealed[i - 1][j + 1] += 1;
                    revealed[i][j - 1] += 1;
                    revealed[i][j + 1] += 1;
                    revealed[i + 1][j - 1] +=1 ;
                    revealed[i + 1][j] += 1;
                    revealed[i + 1][j + 1] += 1;
                    revealed[i][j] = -9;// at most there will be eight mines adjacent to a cell
                }
            }
        }//a bit slow by using revealed[][]
        int x = click[0], y = click[1];
        if (board[x][y] == 'M')
            board[x][y] = 'X';
        dfs(board, revealed, x, y);
        return board;
    }
    
    public void dfs(char[][] board, int[][] revealed, int x, int y) {
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0)
            return;
        if (board[x][y] == 'E') {
            board[x][y] = revealed[x + 1][y + 1] == 0 ? 'B' : (char)('0' + revealed[x + 1][y + 1]);
            if (board[x][y] == 'B') {
                dfs(board, revealed, x - 1, y - 1);
                dfs(board, revealed, x - 1, y);
                dfs(board, revealed, x - 1, y + 1);
                dfs(board, revealed, x, y - 1);
                dfs(board, revealed, x, y + 1);
                dfs(board, revealed, x + 1, y - 1);
                dfs(board, revealed, x + 1, y);
                dfs(board, revealed, x + 1, y + 1);
            }
        }
    }
}

/*
This is a typical Search problem, either by using DFS or BFS. Search rules:

If click on a mine ('M'), mark it as 'X', stop further search.
If click on an empty cell ('E'), depends on how many surrounding mine:
2.1 Has surrounding mine(s), mark it with number of surrounding mine(s), stop further search.
2.2 No surrounding mine, mark it as 'B', continue search its 8 neighbors.
DFS solution.

public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];
        
        if (board[row][col] == 'M') { // Mine
            board[row][col] = 'X';
        }
        else { // Empty
            // Get number of mines first.
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;
                    int r = row + i, c = col + j;
                    if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                    if (board[r][c] == 'M' || board[r][c] == 'X') count++;
                }
            }
            
            if (count > 0) { // If it is not a 'B', stop further DFS.
                board[row][col] = (char)(count + '0');
            }
            else { // Continue DFS to adjacent cells.
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                        if (board[r][c] == 'E') updateBoard(board, new int[] {r, c});
                    }
                }
            }
        }
        
        return board;
    }
}
BFS solution. As you can see the basic logic is almost the same as DFS. Only added a queue to facilitate BFS.

public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            
            if (board[row][col] == 'M') { // Mine
                board[row][col] = 'X';
            }
            else { // Empty
                // Get number of mines first.
                int count = 0;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                        if (board[r][c] == 'M' || board[r][c] == 'X') count++;
                    }
                }
                
                if (count > 0) { // If it is not a 'B', stop further BFS.
                    board[row][col] = (char)(count + '0');
                }
                else { // Continue BFS to adjacent cells.
                    board[row][col] = 'B';
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) continue;
                            int r = row + i, c = col + j;
                            if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                            if (board[r][c] == 'E') {
                                queue.add(new int[] {r, c});
                                board[r][c] = 'B'; // Avoid to be added again.
                            }
                        }
                    }
                }
            }
        }
        
        return board;
    }
}
*/
