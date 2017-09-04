class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1])
                break;
        }
        if (i < 0)
            swap(nums, 0, nums.length -1);
        else {
            int j = nums.length - 1;
            for (; j > i; j--) {
                if (nums[j] > nums[i])
                    break;
            }
            nums[i] += nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] -= nums[j];
            swap(nums, i + 1, nums.length - 1);
        }
    }
    
    public void swap(int[] nums, int left, int right) {
        while (left < right) {
            nums[left] += nums[right];
            nums[right] = nums[left] - nums[right];
            nums[left] -= nums[right];
            left++;
            right--;
        }
    } 
}

/*
The example is really good for understanding the algorithm. Just translate it to English version for your reference.

[6，3，4，9，8，7，1]
     i-1 i    k
(1) leftward find the first decreasing number @ index i - 1, (4)
(2) then nums[i:] must be rightward decreasing (9,8,7,1)
(3) leftward find the first number that is larger than i - 1, which is at k, (7)
(4) swap i - 1 with k, (6,3,7,9,8,4,1). we can see that nums[i:] will still be rightward decreasing (9,8,4,1)
(5) But we need them to be rightward increasing so that it's the smallest after swapping, so we reversed nums[i:], which get the result (6,3,7,1,4,8,9)
*/
