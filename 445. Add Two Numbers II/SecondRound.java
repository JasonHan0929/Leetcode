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
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null) {
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }
        ListNode cur = null;
        ListNode pre = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int value1 = stack1.isEmpty() ? 0 : stack1.pop();
            int value2 = stack2.isEmpty() ? 0 : stack2.pop();
            int curVal = (value1 + value2 + carry) % 10;
            carry = (value1 + value2 + carry) / 10;
            cur = new ListNode(curVal);
            cur.next = pre;
            pre= cur;
        }
        if (carry == 1) {
            cur = new ListNode(1);
            cur.next = pre;
        }
        return cur;
    }
}
