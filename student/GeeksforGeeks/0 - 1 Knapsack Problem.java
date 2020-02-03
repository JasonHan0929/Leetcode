/*
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item, In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of four lines. The first line consists of N the number of items. The second line consists of W, the maximum capacity of the knapsack. In the next  line are N space separated positive integers denoting the values of the N items and in the fourth line are N space separated positive integers denoting the weights of the corresponding items.
 

Output:

Print the maximum possible value you can get with the given conditions that you can obtain for each test case in a new line.
 

Constraints:

1≤T≤100

1≤N≤100

1≤W≤100

1≤wt[i]≤100

1≤v[i]≤100


Example:

Input:
1
3
4
1 2 3
4 5 1
Output:
3
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
	     int sum = 0;
	     for (int i = 0; i < n; i++)
	         sum += weights[i];
         for (int i = 0; i < n; i++) {
             for (int j = W; j >= Math.max(weights[i], W - sum); j--)//optimize space complexity
             //for (int j = W; j >= weights[i]; j--)
                 dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
             sum -= weights[i];
         }
         return dp[W];
	 }
}
