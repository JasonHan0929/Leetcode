class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for (int k = 3; k <= nums.length + 2; k++) {
            for (int i = -1; i <= nums.length - k + 1; i++) {
                int j = i + k - 1;
                int max = 0;
                for (int m = i + 1; m < j; m++) {
                    max = Math.max(max, dp[i + 1][m + 1] + dp[m + 1][j + 1] + getValue(nums, i) * getValue(nums, j) * getValue(nums, m));
                }
                dp[i + 1][j + 1] = max; // dp数组脚标的换算
            }
        }
        //for (int[] line: dp) {
            //System.out.println(Arrays.toString(line));
        //}
        return dp[0][nums.length + 1];
    }

    private int getValue(int[] nums, int index) {
        if (index < 0 || index >= nums.length) {
            return 1;
        }
        return nums[index];
    }
}
