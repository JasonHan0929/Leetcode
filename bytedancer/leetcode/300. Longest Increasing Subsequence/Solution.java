class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tails = new int[nums.length + 1]; // 用贪心的思想维护tails数组，不是很好想到
        tails[1] = nums[0];
        int tailsIndex = 1;
        for (int i = 2; i < nums.length + 1; i++) {
            if (tails[tailsIndex] < nums[i - 1]) {
                tailsIndex++;
                tails[tailsIndex] = nums[i - 1];
            } else {
                int targetIndex = binarySearch(tails, 1, tailsIndex, nums[i - 1]);
                tails[targetIndex] = nums[i - 1];
            }
        }
        return tailsIndex;
    }
    private int binarySearch(int[] array, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target <= array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end + 1;
    }
}
