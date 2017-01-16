public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            if (num == 0)
                sum = 0;
            else
                sum += num;
            max = Math.max(sum, max);
        }
        return max;
    }
}