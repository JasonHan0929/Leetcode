/*
Reverse a linked list (Function Program)
Show Topic Tags         Accolite    Adobe    Cisco    Cognizant    IgniteWorld    Intuit    Mahindra Comviva    MakeMyTrip    Microsoft    Paytm    Qualcomm    SAP-Labs    Snapdeal    Tejas Network    Teradata    VMWare
Given pointer to the head node of a linked list, the task is to reverse the linked list.

Input:
You need to complete a method reverse() that takes head as argument and returns new head.
There are multiple test cases. For each test case, this method will be called individually.  The first line of input contains number of test cases.  Every test case has two lines, number of nodes first line and data values in next line.

Output:
Reverse the linked list and return head of the modified list.


Example:
Input:
1
6
1 2 3 4 5 6

Output:
6 5 4 3 2 1

**For More Examples Use Expected Output**

*/

/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Return reference of new head of the reverse linked list 
 class Node {
     int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
} */
class gfg
{
    // This function should reverse linked list and return
   // head of the modified linked list.
   Node reverse(Node head)
   {
        if (head == null || head.next == null)
            return head;
        Node left = head;
        Node right = head.next;
        while (right != null) {
            Node temp = right.next;
            right.next = left;
            left = right;
            right = temp;
        }
        head.next = null;
        return left;
   }
}
