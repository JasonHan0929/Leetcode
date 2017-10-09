/*
Longest Palindrome in a String
Show Topic Tags         Accolite    Amazon    Groupon    Microsoft
Given a string S, find the longest palindromic substring in S.

Substring of string S:

S[ i . . . . j ] where 0 ≤ i ≤ j < len(S)

Palindrome string:

A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

Incase of conflict, return the substring which occurs first ( with the least starting index ).

Input:

The first line of input consists number of the test cases. The following T lines consist of a string each.


Output:

In each separate line print the longest palindrome of the string given in the respective test case.


Constraints:

1 ≤T≤ 100
1 ≤ str≤ 100


Example:

Input:

1
aaaabbaa

Output:

aabbaa

*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner scanner = new Scanner(System.in);
	    int T = Integer.parseInt(scanner.nextLine().trim());
	    for (int i = 0; i < T; i++) {
	        String input = scanner.nextLine();
	        System.out.println(non_dp(input));
	    }
	 }
	 
	 public static String dp(String input) {
	     int n = input.length();
	     boolean[][] dp = new boolean[n][n];
	     int start = 0, max = 1;// max could not be initilaized with 0
	     for (int i = 0; i < n; i++)
	        dp[i][i] = true;
	     for (int len = 2; len <= n; len++) {
	         for (int i = 0; i < n - len + 1; i++) {
	             int j = i + len - 1;
	             if (len > 2 && dp[i + 1][j - 1] || len <= 2) {
	                 dp[i][j] = input.charAt(i) == input.charAt(j);
	                 if (dp[i][j] && max < len) {
	                     max = len;
	                     start = i;
	                 }
	             }
	         }
	     }
	     return input.substring(start, start + max);// substring(start, end) not substring(start, length)
	 }

	 //another solution

	 static int max = 1, start = 0;
	 public static String non_dp(String input) {
	     int n = input.length();
	     for (int i = 0; i < n; i++) {
	         extend(input, i, i);
	         extend(input, i, i + 1);
	     }
	     return input.substring(start, start + max);
	 }
	 
	 public static void extend(String input, int left, int right) {
	     while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
	         left--;
	         right++;
	     }
	     if (max < right - left - 1) {
	         max = right - left - 1;
	         start = left + 1;
	     }
	 }
}
