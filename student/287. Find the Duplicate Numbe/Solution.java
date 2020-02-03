public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null && nums.length == 0)
            return 0;
        int high = nums.length;//不是length - 1因为这是左闭右开型二分查找
        int low = 1;
        int middle = 0;
        int counter = 0;
        while (low < high) {
            middle = (low + high) / 2;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] <= middle)
                    counter++;
            }
            if(counter > middle)
                high = middle;
            else
                low = middle + 1;
            counter = 0;
        }
        return low;
    }       
}
