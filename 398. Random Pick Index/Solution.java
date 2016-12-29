public class Solution {

    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int index = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == target) {
                count++;
                if (random.nextInt(count) == count - 1)
                    index = i;
            }
        }
        return index;
    }
}//仍然是reservoir sampling

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

public class Solution {

    int[] nums;
    Random rnd;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }
    
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }
        
        return result;
    }
}//更标准写法
