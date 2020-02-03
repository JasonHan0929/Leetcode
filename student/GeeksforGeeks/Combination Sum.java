/*
Combination Sum
Show Topic Tags           Adobe    Amazon    Microsoft
Given an array of integers A and a sum B, find all unique combinations in A where the sum is equal to B. The same repeated number may be chosen from A unlimited number of times.
Note:
All numbers will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The combinations themselves must be sorted in ascending order.
If there is no combination possible the print "Empty" (without qoutes).
Example,
Given A = 2,4,6,8 and B(sum) = 8,
A solution set is:

[2, 2, 2, 2]
[2, 2, 4]
[2, 6]
[4, 4]
[8]

Input:
First is T , no of test cases. 1<=T<=500
Every test case has three lines.
First line is N, size of array. 1<=N<=12
Second line contains N space seperated integers(x). 1<=x<=9.
Third line is the sum B. 1<=B<=30.
 
Output:
One line per test case, every subset enclosed in () and in every set intergers should be space seperated.(See example)

Example:
Input:
3
4
7 2 6 5
16
11
6 5 7 1 8 2 9 9 7 7 9
6
4
5 2 2 6
3

Output:
(2 2 2 2 2 2 2 2)(2 2 2 2 2 6)(2 2 2 5 5)(2 2 5 7)(2 2 6 6)(2 7 7)(5 5 6)
(1 1 1 1 1 1)(1 1 1 1 2)(1 1 2 2)(1 5)(2 2 2)(6)
Empty

**For More Examples Use Expected Output**
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  
    StringBuilder result = new StringBuilder();
    StringBuilder cur = new StringBuilder();
    int[] nums;
	public static void main (String[] args)
	 {  
	    Scanner scanner = new Scanner(System.in);
	    int T = scanner.nextInt();
	    for (int i = 0; i < T; i++) {
	        int n = scanner.nextInt();
	        int[] nums = new int[n];
	        for (int j = 0; j < n; j++)
	            nums[j] = scanner.nextInt();
	        int target = scanner.nextInt();
	        GFG gfg = new GFG();
	        String result = gfg.comb(nums, target);
	        System.out.println(result.length() == 0 ? "Empty" : result);
	    }
	 }
	 public String comb (int[]nums, int target) {
	     this.nums = nums;
	     cur.append('(');
	     Arrays.sort(nums);
	     dfs(target, 0);
	     return result.toString();
	 }
	 public void dfs (int target, int start) {
	     if (target == 0) {
	         cur.setCharAt(cur.length() - 1, ')');
	         result.append(cur);
	     } else {
	         for (int i = start; i < nums.length && nums[i] <= target; i++) {
	             if (i > start && nums[i] == nums[i - 1])
	                continue;
	             cur.append(nums[i]).append(" ");
	             dfs(target - nums[i], i);
	             cur.delete(cur.length() - 2, cur.length());
	         }
	     }
	 }
}//input has duplicates
