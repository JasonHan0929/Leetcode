/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        for (int i = 1; i < m; i++) {
            dummy = dummy.next;
            cur = cur.next;
        }
        ListNode next = cur.next;
        for (int i = m; i < n; i++) {
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        dummy.next.next = next;
        dummy.next = cur;
        return m == 1? dummy.next : head;
    }
}
