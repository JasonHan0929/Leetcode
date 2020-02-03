public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1) {
            return;
        }
        int fastIndex = 1;
        int slowIndex = 0;
        while(fastIndex < nums.length) {
            if(nums[slowIndex] == 0 && nums[fastIndex] != nums[slowIndex]) {
                int tempo = nums[fastIndex];
                nums[fastIndex] = nums[slowIndex];
                nums[slowIndex] = tempo;
                slowIndex++;
                fastIndex++;
            }
            else if(nums[slowIndex] == 0 && nums[slowIndex] == nums[fastIndex]) {
                fastIndex++;
            }
            else {
                fastIndex++;
                slowIndex++;
            }
        }
        return;
    }
}
// else if