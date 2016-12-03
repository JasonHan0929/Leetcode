public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    int sum = target - nums[i] - nums[j] - nums[k];
                    if (map.containsKey(sum) && map.get(sum) > k)   result.add(Arrays.asList(nums[i], nums[j], nums[k], sum));
                }
            }
        }
        return result;
    }
}

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int left;
        int right;
        int sum;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                left = j + 1;
                right = nums.length - 1;
                while (left < right) {
                    sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left <= right && nums[left] == nums[left - 1])
                            left++;
                        while (left <= right && nums[right] == nums[right + 1])
                            right--;
                    }
                    else if (sum < target) {
                        left++;
                        while (left <= right && nums[left] == nums[left - 1])
                            left++;
                    }
                    else {
                        right--;
                        while (left <= right && nums[right] == nums[right + 1])
                            right--;
                    }
                }
            }
        }
        return result;
    }
}//更快

//还可以退化成3sum + 2sum但是应该拆不成两个2sum
