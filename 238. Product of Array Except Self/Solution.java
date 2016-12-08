public class Solution {

    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0)

            return null;

        int n = nums.length;

        int[] result = new int[nums.length];

        int left = 1;

        int right = 1;

        result[0] = 1;

        for (int i = 1; i < n; i++) {

            left *= nums[i-1];

            result[i] = left;

        }

        for (int i = n-2; i >= 0; i--) {

            right *= nums[i+1]; 

            result [i] *= right ;

        }

        return result;

    }

}