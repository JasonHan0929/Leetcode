/*
http://www.practice.geeksforgeeks.org/problem-page.php?pid=1337&nsukey=sL4iPltLHmgRixoYAoUDgf0MZETOjGmJB25FtezCy8x0bDbERcXYAPSpZPf0jtXg9aAdsxZNsc7OoH9MEVMCP5bCHs0GFeEZr2pF5vCM16ktepE%2B%2BPXMn6%2BiuW9DCaxehU70tLcFaBK88PoUwOUSBCHzQvpCUZtAyEFg%2FqEBdYZwkBcBO5PzixDZGRSl2B0p

Flip Bits
dp      Amazon
Given an array arr[] consisting of 0’s and 1’s. A flip operation is one in which you turn 1 into 0 and a 0 into 1.You have to do atmost one “Flip” operation on a subarray. Then finally display maximum number of 1 you can have in the array.

Input:

First line of input consist of a single integer T denoting the total number of test case.First line of test case contains an integer N.Second line of test case contains N space separated integers denoting the array arr[].

Output:
For each test case output a single integer representing  the maximum number of 1's you can have in the array after atmost one flip operation.


Constraints:

1<=T=100
1<=N<=10000
a[i]={0,1}


Example:

Input:

1
5
1 0 0 1 0 

Output:

4

Explanation:

We can perform a flip operation in the range [1,2]

After flip operation array is : 1 1 1 1 0

 

 

**For More Examples Use Expected Output**
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int i = T; i > 0; i--) {
		    int len = scanner.nextInt();
		    int[] array = new int[len];
		    for (int j = 0; j < len; j++) {
		        array[j] = scanner.nextInt();
		    }
		    System.out.println(bitFlip(array));
		}
	}
    /*public static int bitFlip(int[] array) {
        int[][] dp = new int[array.length][array.length];
        int count1 = 0;
        int result = 0;
        for (int num : array) {
            if (num == 1)
                count1++;
        }
        dp[0][0] = array[0] == 0 ? count1 + 1 : count1 - 1;
        for (int i = 1; i < array.length; i++) {
            dp[i][0] = array[i] == 0 ? dp[i - 1][0] + 1 : dp[i - 1][0] - 1;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = array[j - 1] == 0 ? dp[i][j - 1] - 1 : dp[i][ j - 1] + 1;
            }
        }
        for (int[] nums : dp) {
            for (int num : nums)
                result = Math.max(num, result);
        }
        return result;
    }*/ //time limit exceeded
    public static int bitFlip(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0] == 0 ? 1 : -1;
        int count1 = 0;
        int sum = 0;
        for (int num : array)
            if (num == 1) count1++;
        for (int i = 1; i < array.length; i++) {
            int thisDigit = array[i] == 0 ? 1 : -1; 
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + thisDigit : thisDigit;
            sum = Math.max(dp[i], sum);
        }
        return sum + count1;
    }
}//If we replace all the 0's in the array to 1 and all the 1's in the array to -1, the problem can be solved by finding the largest sum contigous subarray.
