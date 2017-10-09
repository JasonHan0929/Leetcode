class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0)
            return m * n;
        int row = Integer.MAX_VALUE;
        int column = Integer.MAX_VALUE;
        for (int[] op : ops) {
            row = Math.min(row, op[0]);
            column = Math.min(column, op[1]);
        }
        return row * column;
    }
}
