public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return true;
        
            if (nums[start] < nums[mid]){
                 if (target < nums[mid] && target >= nums[start]) 
                    end = mid - 1;
                 else
                    start = mid + 1;
            } else if (nums[mid] < nums[start]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                 else
                    end = mid - 1;
            } else {
                start++;
            }
        }
        return false;
    }
}

/*
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }
        
        return false;
    }
In case anyone wonders, yes I agree that we don't need to check two parts. It's just that Doing that can slightly boost the performance, no asymptotic difference though.
*/

/*
public boolean search(int[] nums, int target) {
    int start  = 0, end = nums.length - 1;
    
    //check each num so we will check start == end
    //We always get a sorted part and a half part
    //we can check sorted part to decide where to go next
    while(start <= end){
        int mid = start + (end - start)/2;
        if(nums[mid] == target) return true;
        
        //if left part is sorted
        if(nums[start] < nums[mid]){
            if(target < nums[start] || target > nums[mid]){
                //target is in rotated part
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }else if(nums[start] > nums[mid]){
            //right part is rotated
            
            //target is in rotated part
            if(target < nums[mid] || target > nums[end]){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }else{
            //duplicates, we know nums[mid] != target, so nums[start] != target
            //based on current information, we can only move left pointer to skip one cell
            //thus in the worest case, we would have target: 2, and array like 11111111, then
            //the running time would be O(n)
            start ++;
        }
    }
    
    return false;
}
*/
