public class NumArray {

    int[]sum;
    public NumArray(int[] nums) {
        if (nums == null || nums.length <= 0)
            sum = null;
        else {
            sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++)
                sum[i] = nums[i] + sum[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if (sum == null)
            return 0;
        return i == 0 ? sum[j] : sum[j] - sum[i - 1];
    }
}// no need to use int[][]sum


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
