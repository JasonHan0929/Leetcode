/**
* 0: next_0 = 2, next_1 = 3
* 1: next_0 = 4. next_1 = 5
*/
   

class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] count = new int[2]; // [count_0, count_1]
                countZeroAndOne(count, board, i - 1, j);
                countZeroAndOne(count, board, i + 1, j);
                countZeroAndOne(count, board, i, j + 1);
                countZeroAndOne(count, board, i, j - 1);
                countZeroAndOne(count, board, i - 1, j - 1);
                countZeroAndOne(count, board, i - 1, j + 1);
                countZeroAndOne(count, board, i + 1, j - 1);
                countZeroAndOne(count, board, i + 1, j + 1);
                nextValue(board, count, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 4 || board[i][j] == 2 ? 0 : 1;
            }
        }
    }
    
    public void countZeroAndOne(int[] count, int[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;
        if (board[i][j] == 0 || board[i][j] == 2 || board[i][j] == 3)
            count[0] += 1;
        else
            count[1] += 1;
    }
    
    public void nextValue(int[][] board, int[] count, int i, int j) {
        if (board[i][j] == 0)
            board[i][j] = count[1] == 3 ? 3 : 2;
        else
            board[i][j] = count[1] == 2 || count[1] == 3 ? 5 : 4;
    }
    
}
/*
To solve it in place, we use 2 bits to store 2 states:

[2nd bit, 1st bit] = [next state, current state]

- 00  dead (next) <- dead (current)
- 01  dead (next) <- live (current)  
- 10  live (next) <- dead (current)  
- 11  live (next) <- live (current) 
In the beginning, every cell is either 00 or 01.
Notice that 1st state is independent of 2nd state.
Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
Let's count # of neighbors from 1st state and set 2nd state bit.
Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
In the end, delete every cell's 1st state by doing >> 1.
For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.

Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
Transition 00 -> 10: when board == 0 and lives == 3.
To get the current state, simply do

board[i][j] & 1
To get the next state, simply do

board[i][j] >> 1
Hope this helps!

public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0) return;
    int m = board.length, n = board[0].length;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int lives = liveNeighbors(board, m, n, i, j);

            // In the beginning, every 2nd bit is 0;
            // So we only need to care about when will the 2nd bit become 1.
            if (board[i][j] == 1 && lives >= 2 && lives <= 3) {  
                board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
            }
            if (board[i][j] == 0 && lives == 3) {
                board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
            }
        }
    }

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            board[i][j] >>= 1;  // Get the 2nd state.
        }
    }
}

public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
    int lives = 0;
    for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
        for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
            lives += board[x][y] & 1;
        }
    }
    lives -= board[i][j] & 1;
    return lives;
}
*/
