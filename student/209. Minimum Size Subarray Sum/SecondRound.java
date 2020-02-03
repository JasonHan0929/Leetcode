class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0, right = 0;
        int minLen = -1;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            right++;
            while (sum >= s) {
                if (minLen > right - left || minLen == -1)
                    minLen = right - left;
                sum -= nums[left];
                left++;
            }
        }
        return Math.max(minLen, 0);
    }
}
// same idea as 76. Minimum Window Substring
