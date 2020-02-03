class Solution {
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] houseCount = new int[m][n];
        int houses = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    houses++;
                    bfs(grid, houseCount, distance, i, j);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && houseCount[i][j] == houses) result = Math.min(result, distance[i][j]);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    private void bfs(int[][] grid, int[][] houseCount, int[][] distance, int x, int y) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{x, y});
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = cur[0] + dx[j];
                    int nextY = cur[1] + dy[j];
                    if (nextX < m && nextX >= 0 && nextY < n && nextY >= 0 && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                        houseCount[nextX][nextY]++;
                        distance[nextX][nextY] += level;
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}

/*
public class Solution {

//- beats 98% 9ms JAVA BFS 
//- basically use lee-algroithm, bfs each 1 to find out min distance to each 0, accumulate this distances to each 0 location: distance[][], finally find out min value from distance[][]
//- In the case of cannot find a house to each all house: 
    //- not all 0s can reach each house: reachCount[][] to count the # of house each 0 can reach, only >= houseCount valid
    //- [~~improve speed~~]：not all house can reach each house, in this case, we cannot build such house, 
        -count reachable house #, if < houseCount, return -1 directly!!!!!

public int shortestDistance(int[][] grid) {
    
    if (grid.length == 0 || grid[0].length == 0) {
        return -1;
    }
    
    int m = grid.length;
    int n = grid[0].length;
    int[][] distance = new int[m][n];  //accumulated distance of each house (1) to each 0
    int[][] reachCount = new int[m][n]; //count reachable house for each 0
    int houseCount = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                houseCount++;
            }
        }
    }
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                //houseCount++;
                if (!bfs(grid, distance, reachCount, houseCount, m, n, i, j)) {
                    return -1;
                }
            }
        }
    }
    int minDistance = Integer.MAX_VALUE;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 0 && reachCount[i][j] == houseCount) {
                minDistance = Math.min(minDistance, distance[i][j]);
            }
        }
    }
    return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    
}

private boolean bfs(int[][] grid, int[][] distance, int[][] reachCount, int houseCount, int m, int n, int x, int y) {
    
    int[][] visited = new int[m][n];
    Queue<int[]> q = new LinkedList<int[]>();
    q.offer(new int[]{x, y});  
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};
    int level = 0;
    int count = 0;
    while (!q.isEmpty()) {
        int size = q.size();
        level++;               
        for (int i = 0; i < size; i++) {//level by level
            int[] curr = q.poll();
            for (int k = 0; k < 4; k++) { //visit all neighbors & accumulate distance
                int nx = curr[0] + dx[k];
                int ny = curr[1] + dy[k];
                if (nx >=0 && ny >= 0 && nx < m && ny < n  && visited[nx][ny] == 0) {
                    if (grid[nx][ny] == 0) {
                        distance[nx][ny] += level;
                        visited[nx][ny] = 1;
                        reachCount[nx][ny]++;
                        q.offer(new int[]{nx, ny});
                    } else if (grid[nx][ny] == 1) {
                        count++;
                        visited[nx][ny] = 1;
                    }
                }
            }
        }
    }
    return count == houseCount;
}
*/
