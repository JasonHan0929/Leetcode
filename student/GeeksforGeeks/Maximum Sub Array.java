/*
Maximum Sub Array
array  
Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:

A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]

NOTE 1: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index

 

Input:

The first line contains an integer T, depicting total number of test cases. 
Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.



Output:

Print the Sub-array with maximum sum.


Constraints:


1 ≤ T ≤ 40
1 ≤ N ≤ 100
-100 ≤ A[i] ≤ 100


Example:

Input
2
3
1 2 3
2
-1  2
Output
1 2 3
2
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
	        int len = scanner.nextInt();
	        int[] array = new int[len];
	        for (int j = 0; j < len; j++)
	            array[j] = scanner.nextInt();
	        maxSubarray(array);
	    }
	 }
	public static void maxSubarray(int[] array) {
        int maxStart = 0, maxEnd = 0;
        int start = 0, end = 0;
        int max = 0, sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                if (sum == 0) {
                    start = i;
                    end = i;
                    sum = array[i];
                }
                else {
                    end++;
                    sum += array[i];
                }
                if (sum >= max) {
                    max = sum;
                    maxStart = start;
                    maxEnd = end;
                }
            }
            else
                sum = 0;
        }
        StringBuilder result = new StringBuilder();
        for (int i = maxStart; i <= maxEnd; i++)
            result.append(array[i]).append(" ");
        result.deleteCharAt(result.length() - 1).append("\n");
        System.out.print(result.toString());
    }
}
