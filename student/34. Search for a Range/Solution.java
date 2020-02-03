public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int left = searchLeft(nums, target);
        if (left < 0 || left >= nums.length || nums[left] != target)
            return new int[]{-1, -1};
        int right = searchRight(nums, target);
        return new int[]{left, right};
    }
    public int searchLeft(int[]nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (high >= low) {
            int mid = (low + high) >> 1;
            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;    
        }
        return low;
    }
    public int searchRight(int[]nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (high >= low) {
            int mid = (low + high) >> 1;
            if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return high;
    }
}
/*
public class Solution {
	public int[] searchRange(int[] A, int target) {
		int start = Solution.firstGreaterEqual(A, target);
		if (start == A.length || A[start] != target) {
			return new int[]{-1, -1};
		}
		return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};
	}

	//find the first number that is greater than or equal to target.
	//could return A.length if target is greater than A[A.length-1].
	//actually this is the same as lower_bound in C++ STL.
	private static int firstGreaterEqual(int[] A, int target) {
		int low = 0, high = A.length;
		while (low < high) {
			int mid = low + ((high - low) >> 1);
			//low <= mid < high
			if (A[mid] < target) {
				low = mid + 1;
			} else {
				//should not be mid-1 when A[mid]==target.
				//could be mid even if A[mid]>target because mid<high.
				high = mid;
			}
		}
		return low;
	}
}
*/
