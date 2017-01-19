public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            min = Math.min(num, min);
            sum += num;
        }
        return sum - nums.length * min;
    }
}
/*
Adding 1 to n - 1 elements is the same as subtracting 1 from one element, w.r.t goal of making the elements in the array equal.
So, best way to do this is make all the elements in the array equal to the min element.
sum(array) - n * minimum
public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;//prevent from an overflow of integer
        return res;
    }
}
*/
