/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //if (head == null || head.next == null) {
            //return false;
        //}
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (slow != null && fast != null) {
            if (fast == slow && fast != dummy) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
        }
        return false;
    }
}
