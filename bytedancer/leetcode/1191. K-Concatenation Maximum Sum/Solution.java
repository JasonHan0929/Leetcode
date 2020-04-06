class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return 0;
        }
        int prefix = 0, curPrefix = 0, total = 0;
        int dpPre = 0, dpResult = 0;
        int curSuffix = 0, suffix = 0;
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            total += arr[i];
            curPrefix += arr[i];
            prefix = Math.max(prefix, curPrefix);
            dpPre = Math.max(dpPre + arr[i], arr[i]);
            dpResult = Math.max(dpPre, dpResult);
            curSuffix += arr[j];
            suffix = Math.max(curSuffix, suffix);
        }
        return max((1000000000 + 7), 0, dpResult, k >= 2 ? prefix + suffix : 0, k > 2 ? prefix + suffix + (k - 2L) * total : 0);
    }

    private int max(int mode, long... input) {
        int result = Integer.MIN_VALUE;
        for (long num : input) {
            num %= mode;
            result = Math.max((int)num, result);
        }
        return result;
    } // 注意int会溢出
}
