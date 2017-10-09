class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] len = new int[n];
        int[] count = new int[n];// the number of increasing subarray with lenth of len[i] ends at i
        int result = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            len[i] = count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    } else if (len[j] + 1 == len[i])
                        count[i] += count[j];
                }
            }
            if (maxLen == len[i])// how to deal with [2,2,2,2,2]
                result += count[i];
            else if (maxLen < len[i]) {
                maxLen = len[i];
                result = count[i];
            }
        }
        return result;
    }
}
