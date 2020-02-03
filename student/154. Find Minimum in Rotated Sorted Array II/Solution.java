public class Solution {
    public int findMin(int[] nums) {
        int mid = 0;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];
            else if (nums[mid] > nums[high])
                low = mid + 1;
            else if (nums[mid] < nums[high])
                high = mid - 1;
            else
                high--;//linear enumeration
        }
        return nums[low];
    }
}

/*
public int findMin(int[] nums) {
	 int l = 0, r = nums.length-1;
	 while (l < r) {
		 int mid = (l + r) / 2;
		 if (nums[mid] < nums[r]) {
			 r = mid;
		 } else if (nums[mid] > nums[r]){
			 l = mid + 1;
		 } else {  
			 r--;  //nums[mid]=nums[r] no idea, but we can eliminate nums[r];
		 }
	 }
	 return nums[l];
}// more simple
*/
