/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        int carry = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int temp = 0;
        while (cur2.next != null) {
            temp = cur1.val + cur2.val + carry;
            cur1.val = temp % 10;
            carry = temp / 10;
            if (cur1.next == null) {
                cur1.next = new ListNode(carry);
                carry = 0;
            }
            cur2 = cur2.next;
            cur1 = cur1.next;
        }
        temp = cur1.val + cur2.val + carry;
        cur1.val = temp % 10;
        carry = temp / 10;
        while (carry == 1) {
            if (cur1.next == null) {
                cur1.next = new ListNode(carry);
                break;
            }
            else {
                cur1 = cur1.next;
                temp = cur1.val + carry;
                cur1.val = temp % 10;
                carry = temp / 10;
            }
        }
        return l1;
    }
}
//Two things to make the code simple:
//Whenever one of the two ListNode is null, replace it with 0.
//Keep the while loop going when at least one of the three conditions is met.
//Let me know if there is something wrong. Thanks.
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
}// more simple
