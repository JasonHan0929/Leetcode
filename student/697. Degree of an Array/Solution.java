class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, int[]> index = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (!index.containsKey(num)) index.put(num, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            int[] minMax = index.get(num);
            minMax[0] = Math.min(minMax[0], i);
            minMax[1] = Math.max(minMax[1], i);
            max = Math.max(count.get(num), max);
        }
        int result = nums.length;
        for (int num : nums) {
            if (count.get(num) == max) {
                int[] minMax = index.get(num);
                result = Math.min(result, minMax[1] - minMax[0] + 1);
            }
        }
        return result;
    }
}
