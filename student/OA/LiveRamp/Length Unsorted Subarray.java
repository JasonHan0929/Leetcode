/*
Length Unsorted Subarray
array  
Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] such that sorting this subarray makes the whole array sorted.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the size of array.
The second line of each test case contains N input arr[i].

Output:

Print the minimum length subarray arr[s..e]

Constraints:

1 ≤ T ≤ 80
1 ≤ N ≤ 100
1 ≤ C[i] ≤ 500

Example:

Input
2
11
10 12 20 30 25 40 32 31 35 50 60
9
0 1 15 25 6 7 30 40 50

Output
3 8
2 5

Solution:http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
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
    	     int len = scanner.nextInt();
    	     int[] array = new int[len];
    	     for (int j = 0; j < len; j++)
    	        array[j] = scanner.nextInt();
    	     findSubarray(array);
    	 }
	 }
	 public static void findSubarray (int[] array) {
	     int n = array.length;
	     int left = 0;
	     int right = n - 1;
	     for (int i = 0; i < n - 1; i++) {
	         if (array[i] > array[i + 1]) {
	            left = i;
	            break;
	         }
	     }
	     if (left == n -1) {
	        printResult(new int[]{left, right});
	        return;
	     }
	     for (int i = n - 1; i >= 1; i--) {
	         if (array[i] < array[i - 1]) {
	             right = i;
	             break;
	         }
	     }
	     if (left > right) {
	         int temp = left;
	         left = right;
	         right = temp;
	     }
	     int max = array[left];
	     int min = array[left];
	     for (int i = left + 1; i <= right; i++) {
	         max = Math.max(max, array[i]);
	         min = Math.min(min, array[i]);
	     }
	     int modifiedLeft = left;
	     int modifiedRight = right;
	     for (int i = 0; i < left; i++) {
	         if (array[i] >= min) {
	            modifiedLeft = i;
	            break;
	         }
	     }
	     for (int i = n - 1; i > right; i--) {
	         if (array[i] <= max) {
	             modifiedRight = i;
	             break;
	         }
	     }
	     printResult(new int[]{modifiedLeft, modifiedRight});
	 }
	 public static void printResult (int[] result) {
	     System.out.println(result[0] + " " + result[1]);
	 }
}
