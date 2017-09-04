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
        TreeLinkNode cur = root.left;
        TreeLinkNode head = root.left;
        while (cur != null) {
            if (pre == null) {
                pre = head;
                head = head.left;
                cur = pre.left;
            } else if (cur == pre.left) {
                cur.next = pre.right;
                cur = pre.right;
                pre = pre.next;
            } else {
                cur.next = pre.left;
                cur = pre.left;
            }
        }
    }
}
/*
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level_start=root;
        while(level_start!=null){
            TreeLinkNode cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
                
                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }
}
*/
