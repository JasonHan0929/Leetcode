/*
Knapsack with Duplicate Items
Show Topic Tags         Amazon    Google
Given weights and values related to n items and the maximum capacity allowed for these items. What is the maximum value we can achieve if we can pick any weights any number of times for a total allowed weight of W?

Input:
The first line of input contains an integer denoting the no of test cases. Then T test cases follow . Each test case contains two integers N and W denoting the no of items and the total allowed weight. In the next two lines are space separated values of the array denoting values of the items (val[]) and their weights (wt[]) respectively. 

Output:
For each test case in a new line print the  maximum value which we can achieve if we can pick any weights any number of times for a bag of size W.

Constraints:
1<=T<=100
1<=N, W<=1000
1<=wt[], val[]<=100

Example:
Input:
2
2 3
1 1
2 1 
4 8
1 4 5 7
1 3 4 5
Output:
3
11
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner scanner = new Scanner(System.in);
	    int T= scanner.nextInt();
	    for (int i = 0; i < T; i++) {
	        int n = scanner.nextInt();
	        int W = scanner.nextInt();
	        int[] values = new int[n];
	        int[] weights = new int[n];
	        for (int j = 0; j < n; j++)
	            values[j] = scanner.nextInt();
	        for (int j = 0; j < n; j++)
	            weights[j] = scanner.nextInt();
	        System.out.println(knapsack(values, weights, W));
	    }
	 }
	 public static int knapsack(int[] values, int[] weights, int W) {
	     int n = values.length;
	     int[] dp = new int[W + 1];
         for (int i = 0; i < n; i++) {
             for (int j = weights[i]; j <= W; j++)//optimize space complexity
                 dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
         }
         return dp[W];
	 }
}
