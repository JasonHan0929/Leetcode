public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if (i < 0)
                nums1[k] = nums2[j--];
            else if (j < 0)
                break;
            else if (nums2[j] > nums1[i])
                nums1[k] = nums2[j--];
            else
                nums1[k] = nums1[i--];
        }
    }
}
