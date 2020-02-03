public class Solution {
    public int combinationSum4(int[] nums, int target) {
        return backtracing(0, nums, target);
    }
    public int backtracing(int sum, int[]nums, int target) {
        if (target == 0)
            sum++;
        else {
            for (int i = 0; i < nums.length; i++) {
                if (target - nums[i] >= 0)
                    sum = backtracing(sum, nums, target - nums[i]);
            }
        }
        return sum;
    }
}//回溯版，会超时
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        //Arrays.sort(nums);//没有必要先排序，但是先排序再把continue换成break会变快
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i)
                    continue;
                else if (num == i)
                    dp[i]++;
                else
                    dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}//dp版，什么时候可以用dp呢？
