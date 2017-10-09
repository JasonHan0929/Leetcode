class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 1)
            return true;
        int count = 0;
        int pre = 0, cur = 1;
        while (cur < nums.length && count <= 1) {
            if (nums[pre] > nums[cur]) {
                count++;
                if (pre == 0 || nums[pre - 1] <= nums[cur])
                    nums[pre] = nums[cur];
                else
                    nums[cur] = nums[pre];
            }
            pre++;
            cur++;
        }
        return count <= 1;
    }
}

/*
This problem is like a greedy problem. When you find nums[i-1] > nums[i] for some i, you will prefer to change nums[i-1]'s value, since a larger nums[i] will give you more risks that you get inversion errors after position i. But, if you also find nums[i-2] > nums[i], then you have to change nums[i]'s value instead, or else you need to change both of nums[i-2]'s and nums[i-1]'s values.

Java version:

public boolean checkPossibility(int[] nums) {
	int cnt =0; //the number of changes
	for(int i = 1; i < nums.length && cnt<=1 ; i++){
	    if(nums[i-1] > nums[i]){
		cnt++;
		if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i]; //modify nums[i-1] of a priority
		else nums[i] = nums[i-1]; //have to modify nums[i]
	    }
	}
	return cnt<=1; 
}
*/
