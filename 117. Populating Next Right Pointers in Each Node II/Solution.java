/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        TreeLinkNode pre = root;
        TreeLinkNode cur = pre.left != null ? pre.left : pre.right;
        TreeLinkNode head = null;
        while (cur != null) {
            head = cur;
            while (pre != null) {
                if (pre.left == null && pre.right == null || pre.left == cur && pre.right == null || pre.right == cur) {
                    pre = pre.next;
                    continue;
                } 
                cur.next = pre.left == cur ? pre.right : pre.left == null ? pre.right : pre.left;
                cur = cur.next;
            }
            while (head != null && head.left == null && head.right == null)
                head = head.next;
            if (head == null)
                break;
            pre = head;
            cur = head.left != null ? head.left : head.right;
        }
    }
}

/*
public class Solution {
    public void connect(TreeLinkNode root) {
        
        while(root != null){
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;//use extra space, you should declare currentChild outside the loop
            while(root!=null){
                if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
                if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
                root = root.next;
            }
            root = tempChild.next;
        }
    }
}
*/

/*
public class Solution {
    
    //based on level order traversal
    public void connect(TreeLinkNode root) {

        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while (cur != null) {
            
            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
        
    }
}
*/

