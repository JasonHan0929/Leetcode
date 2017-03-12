/*
Subarray with given sum
array      Amazon    Facebook    Google    Visa
Given an unsorted array of non-negative integers, find a continous subarray which adds to a given number.

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:

Corresponding to each test case, in a new line, print the starting and ending positions of first such occuring subarray if sum equals to subarray, else print -1.

Note: Position of 1st element of the array should be considered as 1.

Expected Time Complexity: O(n)

Constraints:
1 ≤ T ≤ 50
1 ≤ N ≤ 100
1 ≤ an array element ≤ 200

Example:

Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10

Output:
2 4
1 5

Explanation : 
In first test case, sum of elements from 2nd position to 4th position is 12
In second test case, sum of elements from 1st position to 5th position is 15

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
            int len = scanner.nextInt();
            int[] array = new int[len];
            int k = scanner.nextInt();
            for (int i = 0; i < len; i++)
                array[i] = scanner.nextInt();
            findRange(array, k);
        }
    }
    public static void findRange(int[] array, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int start = 0;
        int end = -1;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            end++;
            if (sum >= k) {
                if (!map.isEmpty() && map.containsKey(sum - k)) {
                    start = map.get(sum - k) + 1;
                    System.out.println((start + 1) + " " + (end + 1));
                    return;
                }
                end = i;
            }
            map.put(sum, i);
        }
        System.out.println(-1);
    }
}
