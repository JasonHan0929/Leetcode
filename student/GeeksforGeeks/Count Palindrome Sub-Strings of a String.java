/*
Count Palindrome Sub-Strings of a String
Show Topic Tags          Ola-Cabs
Given a string, the task is to count all palindromic sub-strings present in it.

Input:

The first line of input will contain no of test cases T . Then T test cases follow . Each test case contains 2 lines. The first line of each test case contains an integer N denoting the length of the string, next line of test case contains the string


Output:

For each test case output a single line depecting the number of palindromic substrings present.


Constraints:

1<=T<=100
2<=N<=500


Example:

Input

2
5
abaab
7
abbaeae

Output

3
4

Explanation:

Test Case 1
Input : str = "abaab"
Output: 3
All palindrome substring are : "aba" , "aa" , "baab"

Test Case 2
Input : str = "abbaeae"
Output: 4
All palindrome substring are : "bb" , "abba" ,"aea","eae"

** For More Input/Output Examples Use 'Expected Output' option **
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner scanner = new Scanner(System.in);
	    int T = Integer.valueOf(scanner.nextLine());
	    for (int i = 0; i < T; i++) {
	        int len = Integer.valueOf(scanner.nextLine());
	        String str = scanner.nextLine();
	        System.out.println(countPalindrome(str));
	    }
	 }
	 
	 public static int countPalindrome(String str) {
	     if (str == null || str.length() <= 0) {
	         return 0;
	     }
	     char[] charArray = str.toCharArray();
	     int n = charArray.length;
	     int result = 0;
	     for (int mid = 1; mid < n; mid++) {
	         int left = mid - 1;
	         int right = mid;
	         int count = 0;
	         while (left >= 0 && right < n && charArray[left] == charArray[right]) {
	             count++;
	             left--;
	             right++;
	         }
	         result += count;
	         count = 0;
	         left = mid - 1;
	         right = mid + 1;
	         while (left >= 0 && right < n && charArray[left] == charArray[right]) {
	             count++;
	             left--;
	             right++;
	         }
	         result += count;
	     }
	     return result;
	 }
}
