public class Solution {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        int digit = 1;
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < 32; i++) {
            count = 0;
            for (int num : nums) {
                digit = 1 << i;
                if ((num & digit) == digit)
                    count++;
            }
            result += count * (len - count);
        }
        return result;
    }
}
//ans = ∑(zero[i] * one[i]),  i∈[0, 31]
