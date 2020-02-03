public class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}

/*
It's very good question. As you said, the algorithm does waste a little time for some cases in which @target is found very early. But to support early RETURN, you have to add a IF branch in WHILE block, which costs more time than the former one for general cases. Besides, concise solutions are often easy to understand and therefore to be optimized.

public int searchInsert(int[] nums, int target) {
    int low = 0, high = nums.length;
    while(low < high) {
        int mid = low + (high - low) / 2;
        if(nums[mid] < target)
            low = mid + 1;
        else
            high = mid;
    }
    return low;
}
*/
