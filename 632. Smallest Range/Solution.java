class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(3, (x, y) -> x[0] - y[0]); // int[value, row, column]
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int temp  =nums.get(i).get(0);
            min = Math.min(min, temp);
            max = Math.max(max, temp);
            heap.add(new int[]{temp, i, 0});
        }
        int heapMax = max, heapMin = min;
        while (!heap.isEmpty()) {
            int[] temp = heap.poll();
            if (temp[2] == nums.get(temp[1]).size() - 1)
                break;
            heap.add(new int[]{nums.get(temp[1]).get(temp[2] + 1), temp[1], temp[2] + 1});
            heapMin = heap.peek()[0];
            heapMax = Math.max(nums.get(temp[1]).get(temp[2] + 1), heapMax);
            if (heapMax - heapMin < max - min) {
                min = heapMin;
                max = heapMax;
            }
        }
        return new int[]{min, max};
    }
}
