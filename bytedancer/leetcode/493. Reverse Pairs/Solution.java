class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return getReversePair(nums, Arrays.copyOf(nums, nums.length), 0, nums.length - 1);
    }
    public int getReversePair(int[] nums, int[]temp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int sum = getReversePair(nums, temp,  start, mid) + getReversePair(nums, temp,mid + 1, end);
        int left = start;
        int right = mid + 1, pt = mid + 1;
        int i = start;
        while (left <= mid || right <= end) {
            while (left <= mid && pt <= end && temp[left] > 2L * temp[pt]) {
                pt++;
            } // 不是很高效，在归并外面做会好
            if (left > mid) {
                nums[i] = temp[right];
                right++;
            } else if (right > end) {
                nums[i] = temp[left];
                left++;
                while (left <= mid && pt <= end && temp[left] > 2L * temp[pt]) {
                    pt++;
                }
                sum += pt - (mid + 1);
            } else if (temp[right] <= temp[left]) {
                nums[i] = temp[right];
                right++;
            } else {
                nums[i] = temp[left];
                left++;
                sum += pt - (mid + 1);
            }
            i++;
        }
        System.arraycopy(nums, start, temp, start, end - start + 1);
        //System.out.println(Arrays.toString(new int[]{start, end, sum}));
        //System.out.println(Arrays.toString(nums));
        return sum;
    }
}
