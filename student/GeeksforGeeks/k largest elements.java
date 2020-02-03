/*
k largest elements
Show Topic Tags         Amazon    Microsoft    Walmart labs
Given an array, print k largest elements from the array.  The output elements should be printed in decreasing order.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N and k, N is the size of array and K is the largest elements to be returned.
The second line of each test case contains N input C[i].

Output:

Print the k largest element in descending order.

Constraints:

1 ≤ T ≤ 50
1 ≤ N ≤ 100
K ≤ N
1 ≤ C[i] ≤ 1000

Example:

Input:
2
5 2
12 5 787 1 23
7 3
1 23 12 9 30 2 50

Output:
787 23
50 30 23
 

**For More Examples Use Expected Output**

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int i = T; i > 0; i--) {
		    int n = scanner.nextInt();
		    int k = scanner.nextInt();
		    int[] input = new int[n];
		    for (int j = 0; j < n; j++)
		        input[j] = scanner.nextInt();
		    int[] result = getKLargest(input, k);
		    print(result);
		}
	}
	public static int[] getKLargest(int[] input, int k) {
	    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
	    for (int num : input) {
	        if (minHeap.size() < k)
	            minHeap.add(num);
	        else {
	            if (minHeap.peek() < num) {
	                minHeap.poll();
	                minHeap.add(num);
	            }
	        }
	    }
	    int[] result = new int[k];
	    for (int i = k - 1; i >= 0; i--)
	        result[i] = minHeap.poll();
	    return result;
	}
	public static void print(int[] input) {
	    StringBuilder sb = new StringBuilder();
	    for (int num : input)
	        sb.append(num).append(" ");
	    sb.deleteCharAt(sb.length() - 1);
	    System.out.println(sb.toString());
	}
}

/*
Method 3(Use Sorting)
1) Sort the elements in descending order in O(nLogn)
2) Print the first k numbers of the sorted array O(k).

Time complexity: O(nlogn)

Method 4 (Use Max Heap)
1) Build a Max Heap tree in O(n)
2) Use Extract Max k times to get k maximum elements from the Max Heap O(klogn)

Time complexity: O(n + klogn)

Method 5(Use Oder Statistics)
1) Use order statistic algorithm to find the kth largest element. Please see the topic selection in worst-case linear time O(n)
2) Use QuickSort Partition algorithm to partition around the kth largest number O(n).
3) Sort the k-1 elements (elements greater than the kth largest element) O(kLogk). This step is needed only if sorted output is required.

Time complexity: O(n) if we don’t need the sorted output, otherwise O(n+kLogk)

Thanks to Shilpi for suggesting the first two approaches.

Method 6 (Use Min Heap)
This method is mainly an optimization of method 1. Instead of using temp[] array, use Min Heap.

Thanks to geek4u for suggesting this method.

1) Build a Min Heap MH of the first k elements (arr[0] to arr[k-1]) of the given array. O(k)

2) For each element, after the kth element (arr[k] to arr[n-1]), compare it with root of MH.
……a) If the element is greater than the root then make it root and call heapify for MH
……b) Else ignore it.
// The step 2 is O((n-k)*logk)

3) Finally, MH has k largest elements and root of the MH is the kth largest element.

Time Complexity: O(k + (n-k)Logk) without sorted output. If sorted output is needed then O(k + (n-k)Logk + kLogk)

All of the above methods can also be used to find the kth largest (or smallest) element.
*/
