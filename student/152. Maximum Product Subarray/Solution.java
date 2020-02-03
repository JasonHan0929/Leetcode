public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int preMax = nums[0];
        int preMin = nums[0];
        int num = 0;
        int localMax = 0;
        int localMin = 0;
        for (int i = 1; i < nums.length; i++) {
            num = nums[i];
            localMax = Math.max(Math.max(preMax * num, preMin * num), num);
            localMin = Math.min(Math.min(preMin * num, preMax * num), num);
            preMax = localMax;
            preMin = localMin;
            max = Math.max(max, preMax);
        }
        return max;
    }
}//注意要有localMax和preMax的区分，不然算好的preMax值会干扰正在计算的preMin
/*    简单动态规划：

用数组positive_max[i]维护原始数组前i个数的子数组乘积中正数的最大值
用数组negative_min[i]维护原始数组前i个数的子数组乘积中负数的最小值
状态转移方程为：
if A[x] > 0:
	positive_max[x] = max(positive_max[x - 1] * A[x], A[x])
	negative_min[x] = negative_min[x - 1] * A[x]
elif A[x] < 0:
	positive_max[x] = negative_min[x - 1] * A[x]
	negative_min[x] = min(positive_max[x - 1] * A[x], A[x])*/

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        min[0] = nums[0];
        max[0] = nums[0];
        int num = 0;
        for (int i = 1; i < nums.length; i++) {
            num = nums[i];
            max[i] = Math.max(Math.max(min[i - 1] * num, max[i - 1] * num), nums[i]);
            min[i] = Math.min(Math.min(min[i - 1] * num, max[i - 1] * num), nums[i]);
        }
        int result = Integer.MIN_VALUE;
        for (int number : max) {
            result = Math.max(result, number);
        }
        return result;
    }
}
