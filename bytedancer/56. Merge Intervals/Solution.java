class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        List<int[]> result = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (cur[1] >= interval[0]) {
                cur[0] = Math.min(cur[0], interval[0]);
                cur[1] = Math.max(cur[1], interval[1]);
            } else {
                result.add(cur);
                cur = interval;
            }
        }
        result.add(cur);
        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
