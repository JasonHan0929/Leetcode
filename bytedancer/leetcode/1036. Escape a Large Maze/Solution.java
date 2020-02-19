class Solution {
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked == null) {
            return true;
        }
        Set<String> blockSet = new HashSet<String>();
        for (int[] point : blocked) {
            if (point[0] == target[0] && point[1] == target[1]) {
                return false;
            }
            blockSet.add(String.format("%d_%d", point[0], point[1]));
        }
        if (bfs(new LinkedList<>(), blockSet, new HashSet<>(), source, target) && bfs(new LinkedList<>(), blockSet, new HashSet<>(), target, source)) {
            return true;
        }
        return false;
    }

    private boolean bfs(Queue<int[]> queue, Set<String> blockSet, Set<String> visited, int[] start, int[] end) {
        queue.add(start);
        visited.add(String.format("%d_%d", start[0], start[1]));
        if (start[0] == end[0] && start[1] == end[1]) {
            return true;
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] next : direction) {
                int nextX = cur[0] + next[0], nextY = cur[1] + next[1];
                if (nextX == end[0] && nextY == end[1]) {
                    return true;
                }
                if (nextX >= 1e6 || nextX < 0 || nextY >= 1e6 || nextY < 0) {
                    continue;
                }
                if (visited.contains(String.format("%d_%d", nextX, nextY))){
                    continue;
                }
                if (blockSet.contains(String.format("%d_%d", nextX, nextY))){
                    continue;
                }
                visited.add(String.format("%d_%d", nextX, nextY));
                queue.add(new int[]{nextX, nextY});
            }
            if (queue.size() >= blockSet.size()) {
                return true;
            }
        }
        return false;
    }    
}
