public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] matrix = new List[numCourses];
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            if (matrix[edge[1]] == null)
                matrix[edge[1]] = new LinkedList<>();
            matrix[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            count++;
            if (matrix[pre] == null)
                continue;
            for (int after : matrix[pre]) {
                if (--indegree[after] == 0)
                    queue.offer(after);
            }
        }
        return count == numCourses;
    }
}//BFS, O(v + e)


public class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList[] graph = new ArrayList[numCourses];
            for(int i=0;i<numCourses;i++)
                graph[i] = new ArrayList();
                
            boolean[] visited = new boolean[numCourses];
            for(int i=0; i<prerequisites.length;i++){
                graph[prerequisites[i][1]].add(prerequisites[i][0]);()//could also use graph[prerequisites[i][0]].add(prerequisites[i][1]) but this will cause a bit tricky in logic analysis
            }

            for(int i=0; i<numCourses; i++){
                if(!dfs(graph,visited,i))
                    return false;
            }
            return true;
        }

        private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
            if(visited[course])
                return false;
            else
                visited[course] = true;;

            for(int i=0; i<graph[course].size();i++){
                if(!dfs(graph,visited,(int)graph[course].get(i)))
                    return false;
            }
            visited[course] = false;//only veiry whether there is a cirle in its own connection zone 
            return true;
        }
}//dfs
