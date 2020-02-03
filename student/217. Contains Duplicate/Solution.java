public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null && nums.length <= 1)
            return false;
        Set<Integer> result = new HashSet<>();
        for (int number : nums) {
            if (result.contains(number))
                return true;
            else
                result.add(number);
        }
        return false;
    }
}
