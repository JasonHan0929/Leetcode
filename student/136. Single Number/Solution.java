public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int numbers : nums)
            result = result ^ numbers;
        return result;
    }
}
