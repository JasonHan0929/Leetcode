/*
n'th node from end of linked list (Function Program)
Show Topic Tags         Accolite    Adobe    Amazon    Citicorp    Epic Systems    MAQ-Software    Monotype Solutions    Snapdeal
Given a linked list, the task is to find the n'th node from the end.  It is needed to complete a method that takes two argument, head of linked list and an integer n. There are multiple test cases. For each test case, this method will be called individually.


Input:
The first line of input contains number of test cases.  Every test case cntains two lines.  First line of every test case contains two space separated values, number of nodes  in linked list followed by value of n.  Second line of every test case contains data items of linked list.


Output:
Corresponding to each test case, output a single integer that is the nth integer in the linked list from the end. Print -1 if the value of n is greater than the number of elements in the linked list.

Constraints:
1 <= T <= 50
0 <= No of Nodes <= 1000
0 <= Data in Nodes <= 1000


Example:
Input:
2
9 2
1 2 3 4 5 6 7 8 9
4 5
10 -5 -100 5 
 

Output:
8
-1

In the first example, there are 9 nodes in linked list and we need to find 2nd node from end.  2nd node from end os 8.   In the second example, there are 4 nodes in linked list and we need to find 5th from end.  Since 'n' is more than number of nodes in linked list, output is -1.

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console, and should not print anything on stdout/console. The task is to complete the function specified, and not to write the full code.
 

**For More Examples Use Expected Output**
*/

/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/
class GfG
{
    int getNthFromLast(Node head, int n)
    {
	    Node left = head, right = head;
	    for (int i = 0; i < n; i++)
	        right = right.next;
	    while (right != null) {
	        right = right.next;
	        left = left.next;
	    }
	    return left.data;
    }
}
	
