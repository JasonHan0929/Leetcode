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

/*
public class Solution {
  
  public int findKthLargest(int[] a, int k) {
    int n = a.length;
    int p = quickSelect(a, 0, n - 1, n - k + 1);
    return a[p];
  }
  
  // return the index of the kth smallest number
  int quickSelect(int[] a, int lo, int hi, int k) {
    // use quick sort's idea
    // put nums that are <= pivot to the left
    // put nums that are  > pivot to the right
    int i = lo, j = hi, pivot = a[hi];
    while (i < j) {
      if (a[i++] > pivot) swap(a, --i, --j);
    }
    swap(a, i, hi);
    
    // count the nums that are <= pivot from lo
    int m = i - lo + 1;
    
    // pivot is the one!
    if (m == k)     return i;
    // pivot is too big, so it must be on the left
    else if (m > k) return quickSelect(a, lo, i - 1, k);
    // pivot is too small, so it must be on the right
    else            return quickSelect(a, i + 1, hi, k - m);
  }
  
  void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

}
*/
