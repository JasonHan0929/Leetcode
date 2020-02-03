class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : prerequisites) {
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }
    public boolean dfs(Map<Integer, List<Integer>> graph, int[] visited, int id) {
        if (visited[id] == 0 && graph.containsKey(id)) {
            visited[id] = 1;
            for (int nextId : graph.get(id)) {
                if(visited[nextId] == 1 || !dfs(graph, visited, nextId)) {
                    return false;
                }
            }
            visited[id] = 2;
        }
        return true;
    }
}
