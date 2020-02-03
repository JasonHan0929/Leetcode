class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0 || forest.get(0).size() == 0)
            return -1;
        int m = forest.size(), n = forest.get(0).size();
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1)
                    heap.add(new int[]{i, j, forest.get(i).get(j)});
            }
        }
        int result = 0;
        int[] start = {0, 0};
        while (!heap.isEmpty()) {
            int steps = bfs(start, forest, heap.peek()[2]);
            if (steps == -1)
                return -1;
            result += steps;
            start = heap.poll();
        }
        return result;
    }
    public int bfs(int[] index, List<List<Integer>> forest, int height) {
        int m = forest.size(), n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> queue = new LinkedList<>();
        queue.add(index);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int i = curr[0], j = curr[1];
                if (forest.get(i).get(j) == height)
                    return level;
                else if (forest.get(i).get(j) == 0 || visited[i][j])
                    continue;
                if (i + 1 < m)
                    queue.add(new int[]{i + 1, j});
                if (j + 1 < n)
                    queue.add(new int[]{i, j + 1});
                if (i - 1 >= 0)
                    queue.add(new int[]{i - 1, j});
                if (j - 1 >= 0)
                    queue.add(new int[]{i, j - 1});
                //forest.get(i).set(j, 1);
                visited[i][j] = true;
            }
            level++;
        }
        return -1;
    }
}
//could use AStar algorithm

/*
Since we have to cut trees in order of their height, we first put trees (int[] {row, col, height}) into a priority queue and sort by height.
Poll each tree from the queue and use BFS to find out steps needed.
The worst case time complexity could be O(m^2 * n^2) (m = number of rows, n = number of columns) since there are m * n trees and for each BFS worst case time complexity is O(m * n) too.

class Solution {
    static int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0;
        int m = forest.size(), n = forest.get(0).size();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new int[] {i, j, forest.get(i).get(j)});
                }
            }
        }

        int[] start = new int[2];
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int step = minStep(forest, start, tree, m, n);

            if (step < 0) return -1;
            sum += step;

            start[0] = tree[0];
            start[1] = tree[1];
        }

        return sum;
    }

    private int minStep(List<List<Integer>> forest, int[] start, int[] tree, int m, int n) {
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == tree[0] && curr[1] == tree[1]) return step;

                for (int[] d : dir) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n 
                        || forest.get(nr).get(nc) == 0 || visited[nr][nc]) continue;
                    queue.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
            step++;
        }

        return -1;
    }
}
*/
