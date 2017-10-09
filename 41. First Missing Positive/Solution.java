class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n || nums[i] == i + 1 || nums[nums[i] - 1] == nums[i])// nums[i] > n should write before  nums[i] == i + 1 || nums[nums[i] - 1] 
                continue;
            else {
                swap(i, nums[i] - 1, nums);
                i--;// control i to stay in the same index
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return n + 1;
    }
    
    public void swap(int i, int j, int[] nums) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}

/*
The key here is to use swapping to keep constant space and also make use of the length of the array, which means there can be at most n positive integers. So each time we encounter an valid integer, find its correct position and swap. Otherwise we continue.

public class Solution {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }
    
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
*/
