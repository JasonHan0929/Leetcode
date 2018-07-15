/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur =  dummy;
        while (l1 != null || l2 != null) {
            int sum = carry;
            sum += l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;
            carry = sum / 10;
            sum %= 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        if (carry == 1) cur.next = new ListNode(carry);
        return dummy.next;
    }
}
