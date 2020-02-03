class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        return Math.max(rob(nums, 2, n - 2) + nums[0], rob(nums, 1, n - 1));
    }
    public int rob(int[] nums, int low, int high) { // return [include, exclude]
        if (high < low)
            return 0;
        int include = 0, exclude = 0;
        for (int i = low; i <= high; i++) {
            int temp = exclude;
            temp += nums[i];
            exclude = Math.max(include, exclude);
            include = temp;
        }
        return Math.max(include, exclude);
    }
}

/*
I went over the hot solutions with most votes. Almost all people use the same idea like this one:

(1) i not robbed

(2) i+1 not robbed

Though it looks correct at the first sight, I still don't hundred percent understand why it is correct. Can anyone explain (or prove) in detail???

And my solution also pass to the original rob method twice, but my idea is a little different:

(1) i not robbed

(2) i robbed

Same as the solution above, if i is not robbed, it will break the circle, we can just pass the rest n-1 elements. But if i is robbed, then i-1 and i+1 can not be robbed, it also will break the circle. We can just pass the rest n-3 elements and plus nums[i]. This idea is easy to understand to me because ith house should be either robbed or not robbed. Here I pick i = 0.

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        return Math.max(rob1(Arrays.copyOfRange(nums, 1, nums.length)), nums[0] + rob1(Arrays.copyOfRange(nums, 2, nums.length-1)));
    }
    
    public int rob1(int[] nums) {
        int preno = 0;
        int preyes = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            int tmp = preyes;
            preyes = preno + nums[i];
            preno = Math.max(preno, tmp);
        }
        return Math.max(preyes, preno);
    }
}
*/
