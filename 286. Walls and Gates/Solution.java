class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, new int[]{i, j});
                }
            }
        }
    }
    
    public void bfs(int[][] rooms, int[] coordinate) {
        int[][] nextStep = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int m = rooms.length, n = rooms[0].length;
        Deque<int[]> queue = new LinkedList<>(); // Queue([x, y]...)
        queue.add(coordinate);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) { // step will only be increased 1 after all the nodes in the same level are traversed
                int[] cur = queue.poll();
                rooms[cur[0]][cur[1]] = step;
                for (int[] next : nextStep) {
                    int nextX = cur[0] + next[0];
                    int nextY = cur[1] + next[1];
                    if (nextX < m && nextX >= 0 && nextY < n && nextY >= 0 && rooms[nextX][nextY] > step + 1) {
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
            step++;
        }
    }
}
