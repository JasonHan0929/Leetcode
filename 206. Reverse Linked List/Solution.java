/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode tempo = null;
        slow.next = null;
        while (fast.next != null) {
            tempo = fast.next;
            fast.next = slow;
            slow = fast;
            fast = tempo;
        }
        fast.next = slow;
        return fast;
    }
}
/*private ListNode reverseListInt(ListNode head, ListNode newHead) {
    if (head == null)
        return newHead;
    ListNode next = head.next;
    head.next = newHead;
    return reverseListInt(next, head);
}*/
