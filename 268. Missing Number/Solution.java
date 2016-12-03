public class Solution {
    public int missingNumber(int[] nums) {
        /*if(nums == null || nums.length == 0)
            return -1;
        int[] binary = new int[nums.length + 1];
        Arrays.fill(binary, 0);
        for (int numbers : nums) {
            if (binary[numbers] == 0)
                binary[numbers] = 1;
        }
        int result = -1;
        for (int i = 0 ; i < binary.length; i++) {
            if(binary[i] == 0)
                result = i;
        }
        return result;*/
        
        int sum = (nums.length + 1) * nums.length / 2;
        for (int numbers : nums)
            sum = sum - numbers;
        return sum;
    }
}

/*The basic idea is to use XOR operation. We all know that a^b^b =a, which means two xor operations with the same number will eliminate the number and reveal the original number.
In this solution, I apply XOR operation to both the index and value of the array. In a complete array with no missing numbers, the index and value should be perfectly corresponding( nums[index] = index), so in a missing array, what left finally is the missing number.

public int missingNumber(int[] nums) {

    int xor = 0, i = 0;
	for (i = 0; i < nums.length; i++) {
		xor = xor ^ i ^ nums[i];
	}

	return xor ^ i;
}*/
