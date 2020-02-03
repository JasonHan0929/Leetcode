public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; //注意k可以大于n，当k=n时，数组没有变化而不是逆序
        rotate(nums, 0, n - k -1);
        rotate(nums, n - k, n - 1);
        rotate(nums, 0, n - 1);
    }
    public void rotate(int[] nums, int low, int high) {
        int tempo;
        while (low < high) {
            tempo = nums[high];
            nums[high] = nums[low];
            nums[low] = tempo;
            low++;
            high--;
        }
    }
}
/*
以n - k为界，分别对数组的左右两边执行一次逆置；然后对整个数组执行逆置。

reverse(nums, 0, n - k - 1)
reverse(nums, n - k, n - 1)
reverse(nums, 0, n - 1)
*/
