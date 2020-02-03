public class Solution {
    public boolean canJump(int[] nums) {
        int step = 0;
        int nextStep = 0;
        int max = 0;
        while (step < nums.length - 1) {
            if (step + nums[step] >= nums.length - 1)
                return true;
            for (int i = step + 1; i <= Math.min(nums.length - 1, step + nums[step]); i++) {
                if (i + nums[i] > max) {
                    max = i + nums[i];
                    nextStep = i;
                }
            }
            if (step == nextStep && step != nums.length - 1)
                return false;
            step = nextStep;
        }
        return true;
    }
}// too tangled

public boolean canJump(int[] A) {
    int max = 0;
    for(int i=0;i<A.length;i++){
        if(i>max) {return false;}
        max = Math.max(A[i]+i,max);
    }
    return true;
}

