public class Solution {
    public int minMoves2(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int count = 0;
        while (i < j) 
            count += nums[j--] - nums[i++];
        return count;
    }
}// [0 , 0, 1, 6, 8] select any elements as the final value that to be arrive will have the same result, the difference is once you use median as final value, quick select alogrithm will have a O(n) time complexity to solve this problem
