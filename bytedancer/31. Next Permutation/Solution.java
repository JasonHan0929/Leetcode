class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = nums.length - 2, right = nums.length - 1;
        while (left >= 0 && nums[left] >= nums[right]) {
            left--;
            right--;
        }
        if (left > -1) {
            for (int i = nums.length - 1; i >= right; i--) {
                if (nums[i] > nums[left]) {
                    int temp = nums[left];
                    nums[left] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }
        reverseArray(nums, right, nums.length - 1);
        return;
    }

    private void reverseArray(int[]nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
