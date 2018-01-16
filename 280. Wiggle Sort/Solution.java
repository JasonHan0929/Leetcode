class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0 && nums[i] > nums[i + 1]) swap(nums, i, i + 1);
            if (i % 2 == 1 && nums[i] < nums[i + 1]) swap(nums, i, i + 1);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        nums[i] += nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] -= nums[j];
    }
}
/*
 have to say nobody explains the sufficiency of the following algo:

The final sorted nums needs to satisfy two conditions:

If i is odd, then nums[i] >= nums[i - 1];

If i is even, then nums[i] <= nums[i - 1].

The code is just to fix the orderings of nums that do not satisfy 1
and 2.

(from https://leetcode.com/discuss/57120/4-lines-o-n-c)

why is this greedy solution can ensure previous sequences and coming sequences W.R.T position i wiggled?

My explanation is recursive,

suppose nums[0 .. i - 1] is wiggled, for position i:

if i is odd, we already have, nums[i - 2] >= nums[i - 1],

if nums[i - 1] <= nums[i], then we does not need to do anything, its already wiggled.

if nums[i - 1] > nums[i], then we swap element at i -1 and i. Due to previous wiggled elements (nums[i - 2] >= nums[i - 1]), we know after swap the sequence is ensured to be nums[i - 2] > nums[i - 1] < nums[i], which is wiggled.

similarly,

if i is even, we already have, nums[i - 2] <= nums[i - 1],

if nums[i - 1] >= nums[i], pass

if nums[i - 1] < nums[i], after swap, we are sure to have wiggled nums[i - 2] < nums[i - 1] > nums[i].

The same recursive solution applies to all the elements in the sequence, ensuring the algo success.

public void wiggleSort(int[] nums) {
    for (int i = 1; i < nums.length; i++)
        if (((i & 1) == 0) == (nums[i - 1] < nums[i])) xwap(nums, i);
}

private void xwap(int[] a, int i) {
    int t = a[i]; a[i] = a[i - 1]; a[i - 1] = t;
}
*/
