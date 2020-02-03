/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* A Binary Tree node
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
class GfG
{
    StringBuilder result = new StringBuilder();
    
    void postOrder(Node root)
    {
       //dfs(root);
       //result.deleteCharAt(result.length() - 1);
       //System.out.print(result.toString());
       
       //iterationFromPre(root);
       
       iterationPost(root);
    }
    
    void dfs(Node root) {
        if (root == null)
            return;
        else {
            dfs(root.left);
            dfs(root.right);
            result.append(root.data).append(" ");
        }
    }
    
    void iterationFromPre(Node root) {
        Node curr = root;
        Deque<Node> stack = new LinkedList<>();
        while(!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                result.insert(0, " "+ curr.data);
                curr = curr.right;// not curr.left
            } else {
                curr = stack.pop().left;
            }
        }
        result.deleteCharAt(0);
        System.out.print(result.toString());
    }
    
    void iterationPost(Node root) {
        Node curr = root, pre = null;
        Deque<Node> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.peek();//peek() not pop() because curr might have right child
                if (curr.right == null || curr.right == pre) {
                    result.append(curr.data).append(" ");
                    pre = stack.pop();//pre is used to point to the last node poped from the stack
                    curr = null;
                } else {
                    curr = curr.right;
                }
            }
        }
        result.deleteCharAt(result.length() - 1);
        System.out.print(result.toString());
    }
}
