public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode dummy = new ListNode(-1);
        ListNode tempo;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) sum += stack1.pop();
            if (!stack2.isEmpty()) sum += stack2.pop();
            tempo = dummy.next;
            dummy.next = new ListNode(sum % 10);
            dummy.next.next = tempo;
            sum /= 10;//可以省区int carry变量
        }
        if (sum > 0) {
            tempo = dummy.next;
            dummy.next = new ListNode(sum);
            dummy.next.next = tempo;
        }
        return dummy.next;
    }
}//其实相当于抛弃链表用栈解决，因为对链表操作太繁琐
