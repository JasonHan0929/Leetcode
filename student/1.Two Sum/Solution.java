public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = nums.length - 1; i >= 0; i--) {
        if (map.containsKey(target - nums[i])) return new int[] { i, map.get(target - nums[i]) };
        map.put(nums[i], i);
    }
    return null;
}//注意边比较边加入map的循环方法
