/*
A[...leftA|rightA...] the internul is 0, 1, ... , n and evertime you choose the (midA + 1)th interal
B[...leftB|RightB...]
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if ((n + m) % 2 == 0) {
            return (findKthElement(nums1, nums2, (n + m) / 2) + findKthElement(nums1, nums2, (n + m ) / 2 + 1)) / 2.0;
        } else {
            return (double)findKthElement(nums1, nums2, (n + m + 1) / 2);
        }
    }
    public Integer findKthElement(int[] A, int[] B, int k) {
        int n = A.length, m = B.length;
        if (n > m) {
            return findKthElement(B, A, k);
        } // n <= m
        int l = Math.max(0, k - m), r = Math.min(n, k);
        while (l <= r) {
            int midA = l + (r - l) / 2 - 1; // the internal you choose is actually midA + 1
            int midB = k - midA - 2;
            int leftA = midA < 0 ? Integer.MIN_VALUE : A[midA];
            int leftB = midB < 0 ? Integer.MIN_VALUE : B[midB];
            int rightA = midA + 1 < n ? A[midA + 1] : Integer.MAX_VALUE;
            int rightB = midB + 1 < m ? B[midB + 1] : Integer.MAX_VALUE;
            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                r = midA;
            } else {
                l = midA + 2;
            }
        }
        return null;
    }
}

/* more concise
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        } // n <= m
        int k = (m + n + 1) / 2;
        int l = Math.max(0, k - m), r = Math.min(n, k);
        while (l <= r) {
            int midA = l + (r - l) / 2 - 1; // the internal you choose is actually midA + 1
            int midB = k - midA - 2;
            int leftA = midA < 0 ? Integer.MIN_VALUE : nums1[midA];
            int leftB = midB < 0 ? Integer.MIN_VALUE : nums2[midB];
            int rightA = midA + 1 < n ? nums1[midA + 1] : Integer.MAX_VALUE;
            int rightB = midB + 1 < m ? nums2[midB + 1] : Integer.MAX_VALUE;
            if (leftA <= rightB && leftB <= rightA) {
                return (m + n) % 2 == 0 ? (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0 : (double)Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                r = midA;
            } else {
                l = midA + 2;
            }
        }
        return 0; // should not reach this line
    }
}
*/
