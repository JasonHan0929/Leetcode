public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        int range = 0;
        int count = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1;) {
            for (int j = nums[i] + i; j > i; j--) {
                if (j >= nums.length - 1) {
                    step = nums.length - 1;
                    break;
                }
                else if (range < nums[j] + j) {
                    step = j;
                    range = nums[j] + j;
                }
            }
            count++;
            i = step;
        }
        return count;
    }
}// no need to figure out which index is the next step
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        int newRange = 0;
        int lastRange = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {// at every range's start point, count++, not every terminal point, so use lenght - 1
            newRange = Math.max(nums[i] + i, newRange);
            if (i == lastRange) {
                count++;
                lastRange = newRange;
            }
        }
        return count;
    }
}
