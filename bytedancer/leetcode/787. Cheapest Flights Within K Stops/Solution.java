class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //return bellmanFord(n, flights, src, dst, K);
        return dijkstra(n, flights, src, dst, K);
    }

    private int bellmanFord(int n, int[][] flights, int src, int dst, int K) {
        int[] pre = new int[n], cur = new int[n];
        Arrays.fill(pre, -1);
        Arrays.fill(cur, -1);
        pre[src] = cur[src] = 0;
        for (int i = 0; i <= K; i++) {
            for (int[] edge : flights) {
                if (pre[edge[0]] == -1) { // 没联通的
                    continue;
                }
                if (cur[edge[1]] == -1) { // 同步cur保持与pre在未更新前一致
                    cur[edge[1]] = pre[edge[1]];
                }
                int newPath = pre[edge[0]] == -1 ? Integer.MAX_VALUE : pre[edge[0]] + edge[2];
                int oldPath = cur[edge[1]] == -1 ? Integer.MAX_VALUE : cur[edge[1]];
                cur[edge[1]] = Math.min(newPath, oldPath);
            }
            int[] temp = pre;
            pre = cur;
            cur = temp;
        }
        return pre[dst];
    }

    private int bellmanFordAdvance(int n, int[][] flights, int src, int dst, int K) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;
        int[][] graph = new int[n][n];
        for (int[] edge : flights) {
            graph[edge[0]][edge[1]] = edge[2];
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        for (int i = 0; i <= K; i++) {
            int size = queue.size();
            int[] curDp = Arrays.copyOf(dp, dp.length);
            for (int j = 0; j < size; j++) {
                int cur = queue.poll();
                for (int next = 0; next < n; next++) {
                    if (graph[cur][next] > 0) {
                        curDp[next] = Math.min(dp[next], dp[cur] + graph[cur][next]);
                        queue.add(next);
                    }
                }
            }
            dp = curDp;
        }
        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    } // 该方法不对，因为当到达莫哥node的路径变小的时候，应该继续更新该node可以到达的所有子节点的值

    private int dijkstra(int n, int[][] flights, int src, int dst, int K) {
        HashMap<String, Integer> dp = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        HashMap<Integer, List<int[]>> edgeMap = new HashMap<>();
        for (int[] edge : flights) {
            if (!edgeMap.containsKey(edge[0])) {
                edgeMap.put(edge[0], new ArrayList<>());
            }
            List<int[]> edges = edgeMap.get(edge[0]);
            edges.add(edge);
        }
        pq.add(new int[]{0, 0, src}); // [cost, k, next]
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            //System.out.println(Arrays.toString(cur));
            if (cur[2] == dst) {
                return cur[0];
            }
            String dpKey = String.format("%d_%d", cur[1], cur[2]);
            if (cur[0] >= dp.getOrDefault(dpKey, Integer.MAX_VALUE)) {
                continue;
            }
            dp.put(dpKey, Math.min(dp.getOrDefault(dpKey, Integer.MAX_VALUE), cur[0]));
            List<int[]> nextEdges = edgeMap.get(cur[2]);
            if (nextEdges == null || cur[1] >= K + 1) {
                continue;
            }
            for (int[] edge : nextEdges) {
                pq.add(new int[]{cur[0] + edge[2], cur[1] + 1, edge[1]});
            }
        }
        return -1;
    }
}
