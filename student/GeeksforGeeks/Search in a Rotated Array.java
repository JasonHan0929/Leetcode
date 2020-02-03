/*
Search in a Rotated Array
Show Topic Tags         Adobe    Amazon    BankBazaar    D-E-Shaw    Flipkart    Hike    Intuit    MakeMyTrip    Microsoft    Paytm    Snapdeal    Times Internet
Given a sorted and rotated array (rotated at some point) A[ ], and given an element K, the task is to find the index of the given element K in the array A[ ]. The array has no duplicate elements. If the element does not exist in the array, print -1.
 

Input:
The first line of the input contains an integer T, depicting the total number of test cases. Then T test cases follow. Each test case consists of three lines. First line of each test case contains an integer N denoting the size of the given array. Second line of each test case contains N space separated integers denoting the elements of the array A[ ]. Third line of each test case contains an integer K denoting the element to be searched in the array.


Output:

Corresponding to each test case, print in a new line, the index of the element found in the array.  If element is not present, then print -1.


Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 100005
0 ≤ A[i] ≤ 10000005
1 ≤ k ≤ 100005


Example:

Input
3
9
5 6 7 8 9 10 1 2 3
10
3
3 1 2
1
4
3 5 1 2
6


Output
5
1
-1

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
	        for (int j = 0; j < n; j++) {
	            nums[j] = scanner.nextInt();
	        }
	        int k = scanner.nextInt();
	        System.out.println(search(nums, k));
	    }
	 }
	 public static int search(int[] nums, int k) {
	     int left = 0, right = nums.length - 1;
	     int mid = left + (right - left) / 2;
	     while (left <= right) {
	         mid = left + (right - left) / 2;
	         if (nums[mid] == k)
	            return mid;
	         if (nums[left] <= nums[mid]) {
	             if (nums[left] <= k && nums[mid] > k)
	                right = mid - 1;
	             else
	                left = mid + 1;
	         } else {
	             if (nums[right] >= k && nums[mid] < k)
	                left = mid + 1;
	             else
	                right = mid - 1;
	         }
	     }
	     return -1;
	 }
}
