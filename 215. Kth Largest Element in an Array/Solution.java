public class Solution {
    public int findKthLargest(int[] nums, int k) {
        quicksort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }
    public void quicksort(int[] nums, int low, int high) {//快速排序的写法很多坑
        if (high <= low)
            return;
        int compare = nums[low];
        int left = low;
        int right = high + 1;
        while (left < right) {//注意没有==
            while (nums[++left] < compare && left < high){}//++left而不是while(...) left++用于防止相等时候跳不出循环
            while (nums[--right] > compare && right > low){}
            if (left < right)// 注意没有=， ==情况已经找到了compare的确切位置直接跳出即可
                switchValue(nums, left, right);
        }
        switchValue(nums, low, right); //注意一定要用right而非left因为right存在跨过left的情况，例如[-1,2,0]第一个数即为最小数
        quicksort(nums, low, right - 1);
        quicksort(nums, right + 1, high);
    }
    public void switchValue(int[] array, int indexA, int indexB) {
        int tempo = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tempo;
    }
}
