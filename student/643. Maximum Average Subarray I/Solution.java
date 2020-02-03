class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0, right = 0;
        double sum = 0;
        while (right < k) {
            sum += nums[right];
            right++;
        }
        double max = sum / k;
        while (right < nums.length) {
            sum -= nums[left];
            left++;
            sum += nums[right];
            right++;
            max = Math.max(max, sum / k);
        }
        return max;
    }
}

/*
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int curr = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
        	curr += nums[i];
        	if(i - k  >=0) curr -= nums[i-k];
        	if(i >= k-1 )max = Math.max(curr,max);
        }
        return (double)max/k;
    }

}
*/
