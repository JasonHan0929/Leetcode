public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    public int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;
        int mid = left + ((right - left) >> 1);
        if (nums[mid] == target)
            return mid;
        else if (target == nums[left])
            return left;
        else if (target == nums[right])
            return right;
        else if (nums[left] < nums[mid]) {
            if (target > nums[mid] || (nums[mid] > nums[right] && target < nums[right])) // nums[mid] > nums[right] is used to pass this case: [1,2,3,4,5] find 2
                return binarySearch(nums, mid + 1, right - 1, target);
            else if (target < nums[mid] && target > nums[left])
                return binarySearch(nums, left + 1, mid - 1, target);
        } else if (nums[left] > nums[mid]) {
            if (target > nums[mid] && target < nums[right])
                return binarySearch(nums, mid + 1, right - 1, target);
            else if (target > nums[left] || target < nums[mid])
                return binarySearch(nums, left + 1, mid - 1, target);
        }
        return -1;// left == right && target != mid or target not in the [left, right]
    }
}// logic is a bit confused

/*
The idea is that when rotating the array, there must be one half of the array that is still in sorted order.
For example, 6 7 1 2 3 4 5, the order is disrupted from the point between 7 and 1. So when doing binary search, we can make a judgement that which part is ordered and whether the target is in that range, if yes, continue the search in that half, if not continue in the other half.

public class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
        
            if (nums[start] <= nums[mid]){
                 if (target < nums[mid] && target >= nums[start]) 
                    end = mid - 1;
                 else
                    start = mid + 1;
            } 
        
            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                 else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
*/
