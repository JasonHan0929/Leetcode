/*
Adding Ones
array  dp  
You start with an array A of size N. Also, A[i] = 0 for i = 1 to N. You will be given K positive integers. Let j be one of these integers, you have to add 1 to all A[i], for i >= j. Your task is to print the array A after all these K updates are done.
 

Input:
The first line of input contains an integer  T, denoting the number of test cases. Then T test cases follow. The first line of each test case consists of two space separated positive integers N and K. The second line consists of K space separated integers.
 

Output:
For each test case, in a new line print the array A from the first index to the last index after the K updates are done. Consecutive values are to be separated by a single space between them while printing.
 

Constraints:
1<= T <=100
1<= N, K <=1000

Example: 
Input:
2
3 4
1 1 2 3
2 3
1 1 1
Output:
2 3 4
3 3


Explanation: 
First Test Case
Initially the array is {0, 0, 0}. After the first 1, it becomes {1, 1, 1}. After the second 1 it becomes {2, 2, 2}. After 2, it becomes {2, 3, 3}. After 3 it becomes, {2, 3, 4}.

Second Test Case
Initially the array is {0, 0}. After the first 1, it becomes {1, 1}. After the second 1 it becomes {2, 2}. After the third 1, it becomes {3, 3}.

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
	    while (T-- > 0) {
	        int n = scanner.nextInt();
	        int len = scanner.nextInt();
	        int[] k = new int[len];
	        for (int i = 0; i < len; i++)
	            k[i] = scanner.nextInt();
	        solution(n, k);
	    }
	 }
	 public static void solution(int n, int[] k) {
	     int[] array = new int[n];
	     for (int num : k)
	         array[num - 1] += 1;
	     for (int i = 1; i < n; i++)
	         array[i] += array[i - 1];
	     printArray(array);
	 }
	 public static void printArray(int[] array) {
	     StringBuilder builder = new StringBuilder();
	     for (int num : array) {
	        builder.append(num);
	        builder.append(" ");
	     }
	     builder.deleteCharAt(builder.length() - 1);
	     System.out.println(builder.toString());
	 }
}