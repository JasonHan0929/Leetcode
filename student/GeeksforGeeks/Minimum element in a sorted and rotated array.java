/*Minimum element in a sorted and rotated array
Show Topic Tags         Adobe    Amazon    Microsoft    Morgan-Stanley    Snapdeal    Times Internet
A sorted array A[ ] with distinct elements is rotated at some unknown point, the task is to find the minimum element in it.

Expected Time Complexity: O(Log n)

Input:

The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines. The first line of each test case consists of an integer N, where N is the size of array.
The second line of each test case contains N space separated integers denoting array elements.

Output:
Corresponding to each test case, in a new line, print the minimum element in the array.

Constraints:

1 ≤ T ≤ 200
1 ≤ N ≤ 500
1 ≤ A[i] ≤ 1000

Example:

Input
1
5
4 5 1 2 3

Output
1

**For More Examples Use Expected Output**

*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner scanner = new Scanner(System.in);
	    int T = scanner.nextInt();
	    for (int i = 0; i < T; i++) {
	        int n = scanner.nextInt();
	        int[] nums = new int[n];
	        for (int j = 0; j < n; j++)
	            nums[j] = scanner.nextInt();
	        System.out.println(findMin(nums));
	    }
	 }
	 public static int findMin(int[] nums) {
	     int left = 0, right = nums.length - 1;
	     while (left <= right) {
	         int mid = left + (right - left) / 2;
	         if (nums[left] <= nums[right]) {
	             if (right >= nums.length - 1)
	                return nums[left];
	             return Math.min(nums[left], nums[right + 1]);
	         }
	         else {
	             if (nums[left] <= nums[mid])//should abandon left part first when nums[mid] = max
	                left = mid + 1;
	             else
	                right = mid - 1;
	         }
	     }
	     return nums[right];//only happens when left = max, right = min
	 }
}//input has no duplicates
