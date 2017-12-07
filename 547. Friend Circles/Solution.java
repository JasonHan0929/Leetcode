class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length <= 0) return 0;
        int n = M.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][]M, int i, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < visited.length; j++) {
            if (!visited[j] && M[i][j] == 1) {
                dfs(M, j, visited);
            }
        }
    }
}
