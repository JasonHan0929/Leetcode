/*
Missing number in array
Show Topic Tags           Amazon    Cisco    Intuit    Microsoft    Ola-Cabs    Payu
Given an array of size n-1 and given that there are numbers from 1 to n with one missing, the missing number is to be found.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,size of array.
The second line of each test case contains N-1 input C[i],numbers in array.

Output:

Print the missing number in array.

Constraints:

1 ≤ T ≤ 200
1 ≤ N ≤ 1000
1 ≤ C[i] ≤ 1000

Example:

Input
2
5
1 2 3 5
10
1 2 3 4 5 6 7 8 10

Output
4
9
 

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
	        int[] nums = new int[n - 1];
	        for (int j = 0; j < n - 1; j++) {
	            nums[j] = scanner.nextInt();
	        }
	        System.out.println(findMissingNumByXor(nums, n));
	    }
	 }
	 public static int findMissingNumBySum(int[] nums, int n) {
	     long sum = (1 + n) * n / 2;
	     for (int num : nums) {
	         sum -= num;
	     }
	     return (int)sum;
	 }
	 
	 public static int findMissingNumByXor(int[] nums, int n) {
	     int xor1 = 0, xor2 = 0;
	     for (int i = 1; i <= n - 1; i++) {
	         xor1 ^= nums[i - 1];
	         xor2 ^= i;
	     }
	     xor2 ^= n;
	     return xor1 ^ xor2;
	 }
}
