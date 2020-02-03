public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2)
            sum += nums[i];
        return sum;
    }
}

/*
https://discuss.leetcode.com/topic/87206/java-solution-sorting-and-rough-proof-of-algorithm/2
*/
