public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer>  set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = set.ceiling(nums[i] < 0 && Integer.MIN_VALUE - nums[i] > -t ? Integer.MIN_VALUE : nums[i] - t);
            Integer floor = set.floor(nums[i] > 0 && Integer.MAX_VALUE - nums[i] < t ? Integer.MAX_VALUE : nums[i] + t);//avoid overflow
            if ((ceiling != null && ceiling <= nums[i]) || (floor != null && floor >= nums[i]))
                return true;
            set.add(nums[i]);
            if (i >= k)
                set.remove(nums[i - k]);//main tain a window
        }
        return false;
    }
}//use TreeSet
