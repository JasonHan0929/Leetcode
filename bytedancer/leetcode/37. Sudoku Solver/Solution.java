class Solution {
    public void solveSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] rowNum = new boolean[m][10];
        boolean[][] columnNum = new boolean[n][10];
        boolean[][] squareNum = new boolean[9][10];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    updateNum(rowNum, columnNum, squareNum, i, j , board[i][j] - '0', true);
                }
            }
        }
        dfs(board, rowNum, columnNum, squareNum, 0, 0);
    }

    private boolean dfs(char[][] board, boolean[][] rowNum, boolean[][] columnNum, boolean[][] squareNum, int i, int j) {
        if (i == board.length) {
            return true;
        }
        if (board[i][j] != '.') {
            int[] next = newIJ(board, i, j);
            return dfs(board, rowNum, columnNum, squareNum, next[0], next[1]);
        }
        for (int p = 1; p <= 9; p++) {
            if (rowNum[i][p] || columnNum[j][p] || squareNum[getSquareIndex(i, j)][p]) {
                continue;
            }
            updateNum(rowNum, columnNum, squareNum, i, j , p, true);
            board[i][j] = (char)('0' + p);
            int[] next = newIJ(board, i, j); // 注意这个地方不要改i， j不然后面恢复的时候还会依赖i， j
            if (dfs(board, rowNum, columnNum, squareNum, next[0], next[1])) {
                return true;
            }
            updateNum(rowNum, columnNum, squareNum, i, j, p, false);
        }
        board[i][j] = '.'; // 注意还原的位置，在不在for里
        return false;
    }

    private int getSquareIndex(int i, int j) {
        int row = i / 3;
        int col = j / 3;
        return row * 3 + col;
    }

    private void updateNum(boolean[][] rowNum, boolean[][] columnNum, boolean[][] squareNum, int i, int j, int p, boolean value) {
        rowNum[i][p] = value;
        columnNum[j][p] = value;
        squareNum[getSquareIndex(i, j)][p] = value;
        return;
    }

    private int[] newIJ(char[][] board, int i , int j) {
        if (j == board[0].length - 1) {
            i++;
            j = 0;
        } else {
            j++;
        }
        return new int[]{i, j};
    }
}
