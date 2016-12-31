/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return assist(head, null);
    }
    public TreeNode assist(ListNode head, ListNode tail) {
        if (head == tail)//注意结束标志是head==tail不是head==null
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode treeHead = new TreeNode(slow.val);
        treeHead.left = assist(head, slow);
        treeHead.right = assist(slow.next, tail);
        return treeHead;
    }
}//不需要去写个findMid方法去找链表中电把链表当数组来处理，那样很麻烦
