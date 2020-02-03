class Solution {
    public int maximumProduct(int[] nums) {
        int[] max = new int[3]; // [first biggest, second, third]
        int[] min = new int[2]; // [first smallest, second]
        Arrays.fill(max, Integer.MIN_VALUE);
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int num : nums) {
            if (max[0] < num) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = num;
            } else if (max[1] < num) {
                max[2] = max[1];
                max[1] = num;
            } else if (max[2] < num)
                max[2] = num;
            if (min[0] > num) {
                min[1] = min[0]; 
                min[0] = num;
            } else if (min[1] > num)
                min[1] = num;
        }
        return max[0] * Math.max(max[1]*max[2], min[0]*min[1]);
    }
}
