/*Insert a node in a BST (Function Program)
Show Topic Tags         Amazon    Microsoft
Given a Binary Search Tree (BST) your task is to complete the function insert which inserts a node in the BST.
You should not read any input from stdin/console. There are multiple test cases. For each test case, this method will be called individually.

Input (only to be used for Expected Output):
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of three lines. Description of  test cases is as follows:
The First line of each test case contains an integer 'N' which denotes the no of nodes to be inserted in the BST.   .
The Second line of each test case contains 'N' space separated values  of the nodes to be inserted in the BST.

Output:
You are required to complete the function insert which takes two arguments. The first being the root of the tree, and an integer 'x'denoting the node to be inserted to the BST . 

Constraints:
1 <= T <= 100
1 <= N <= 100


Example:
Input
2
7
2 81 87 42 66 90 45 
4
6 7 9 8

Output
2 42 45 66 81 87 90
6 7 8 9

Note : Here the output is the inorder traversal of the BST.
 

**For More Examples Use Expected Output**
*/

/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Structure of BST node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null; }
}*/
class GfG
{
   /* This function should insert a new node with given data and
      return root of the modified tree  */
    Node insert(Node root, int data)
    {
        if (root == null)
            return new Node(data);
        Node cur = root;
        while (true) {
            if (cur.data > data) {
                if (cur.left == null) {
                    cur.left = new Node(data);
                    break;
                }
                else
                    cur = cur.left;
            } else if (cur.data < data){
                if (cur.right == null) {
                    cur.right = new Node(data);
                    break;
                }
                else
                    cur = cur.right;
            } else
                break;
        }
        return root;
    }
}
