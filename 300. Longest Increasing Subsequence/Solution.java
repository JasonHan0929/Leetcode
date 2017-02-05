public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 0)
            return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }//dp[i] means the max length when using nums[i], since the final result must use at least one of the elements of nums, so there is no need to maintains another state of nums[i] that is 'if this element is not used'
        int result = 0;
        for (int num : dp)
            result = Math.max(num, result);
        return result;
    }
}//dp
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        int len = 0;
        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0 ,len, num);
            index = index < 0 ? -(index + 1) : index;
            dp[index] = num;
            len = index == len ? len + 1 : len;
        }
        return len;
    }
}//niu B approach
/*
The basic idea is present in the majority of solutions shared for this task, I have only tried to implement it in a manner as concise as possible without damaging the code readability.

The idea is that as you iterate the sequence, you keep track of the minimum value a subsequence of given length might end with, for all so far possible subsequence lengths. So dp[i] is the minimum value a subsequence of length i+1 might end with. Having this info, for each new number we iterate to, we can determine the longest subsequence where it can be appended using binary search. The final answer is the length of the longest subsequence we found so far.
*/
