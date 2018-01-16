class TicTacToe {
    
    private final int[] rows;
    private final int[] columns;
    private int diagnoal = 0;
    private int antidiagnoal = 0;
    private final int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        size = n;
        rows = new int[n];
        columns = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int value = player == 1 ? 1 : -1;
        rows[row] += value;
        columns[col] += value;
        if (col == row) diagnoal += value;
        if (col + row == size - 1) antidiagnoal += value;
        if (Math.abs(rows[row]) == size || Math.abs(columns[col]) == size
            || Math.abs(diagnoal) == size || Math.abs(antidiagnoal) == size) { 
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
