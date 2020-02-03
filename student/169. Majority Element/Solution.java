public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int counter = 0;
        int digit = 1;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int number : nums) {
                counter += (number & digit) == digit ? 1 : 0;
            }
            result += counter >= (nums.length / 2 +1) ? digit : 0;
            digit *= 2;
            counter = 0;
        }
        return result;
    }
}
