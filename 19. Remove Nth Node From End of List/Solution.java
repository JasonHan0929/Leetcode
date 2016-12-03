/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fake = new ListNode(0);
        fake.next = head;//建一堆有的没的，省略的left，before在left前一个
        ListNode before = fake;
        ListNode right = before.next;
        for (int i = 1; i < n; i++)
            right = right.next;
        while (right != null && right.next != null) {
            before = before.next;
            right = right.next;
        }
        before.next = before.next.next;
        return fake.next;
    }
}
