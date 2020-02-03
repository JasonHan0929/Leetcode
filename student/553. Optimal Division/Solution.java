public class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums.length > 2 && i == 1)
                sb.append("/(").append(nums[i]);
            else
                sb.append("/").append(nums[i]);
        }
        return nums.length <= 2 ? sb.toString() : sb.append(")").toString();
    }
}//no need to use DP or backtracking
