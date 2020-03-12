class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> leftHeap = new PriorityQueue<>(buildings.length, (x, y) -> (x[0] - y[0] == 0 ? y[2] - x[2] : x[0] - y[0])); // [[1, 2, 1], [1, 2, 2]]
        PriorityQueue<int[]> rightHeap = new PriorityQueue<>(buildings.length, (x, y) -> (x[1] - y[1] == 0 ? x[2] - y[2] : x[1] - y[1]));
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < buildings.length; i++) {
            rightHeap.add(buildings[i]);
            leftHeap.add(buildings[i]);
        }
        while (!leftHeap.isEmpty() || !rightHeap.isEmpty()) {
            Integer leftMin = leftHeap.isEmpty() ? null : leftHeap.peek()[0];
            Integer rightMin = rightHeap.isEmpty() ? null : rightHeap.peek()[1]; // [1, MAX_VALUE, 1]
            if (leftMin != null && leftMin <= rightMin) { // [[0,2,3],[2,5,3]]
                int[] cur = leftHeap.poll();
                int tallest = treeMap.isEmpty() ? 0 : treeMap.lastKey();
                if (tallest < cur[2]) {
                    result.add(new ArrayList<>(Arrays.asList(cur[0], cur[2])));
                }
                treeMap.put(cur[2], treeMap.getOrDefault(cur[2], 0) + 1);
            } else {
                int[] cur = rightHeap.poll();
                if (treeMap.getOrDefault(cur[2], 1) == 1) {
                    treeMap.remove(cur[2]);
                } else {
                    treeMap.put(cur[2], treeMap.get(cur[2]) - 1);
                }
                int tallest = treeMap.isEmpty() ? 0 : treeMap.lastKey();
                if (tallest < cur[2]) {
                    result.add(new ArrayList<>(Arrays.asList(cur[1],tallest)));
                }
            }
        }
        return result;
    }
}
