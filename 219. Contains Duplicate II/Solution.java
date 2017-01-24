public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)// no need to use Math.abs
                return true;
            else
                map.put(nums[i], i);// every time update the index of value equal to num[i] with the bigest index
        }
        return false;
    }
}

public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;//use the method set.add is much simple
        }
        return false;
 }//using set could also solve this problem
