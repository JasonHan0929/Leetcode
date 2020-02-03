/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        int carry = 1;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            cur.val += carry;
            carry = cur.val / 10;
            cur.val %= 10;
        }
        if (carry == 1) {
            cur = new ListNode(carry);
            cur.next = head;
            head = cur;
        }
        return head;
    }
}

/*
public ListNode plusOne(ListNode head) {
    if( DFS(head) == 0){
        return head;
    }else{
        ListNode newHead = new ListNode(1);
        newHead.next = head;
        return newHead;
    }
}

public int DFS(ListNode head){
    if(head == null) return 1;
    
    int carry = DFS(head.next);
    
    if(carry == 0) return 0;
    
    int val = head.val + 1;
    head.val = val%10;
    return val/10;
}
*/

/* two pointers

    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return new ListNode(1);
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast.next != null) {
            if (fast.val != 9) {
                slow = fast;
            }
            fast = fast.next;
        }
        if (fast.val != 9) {
            fast.val++;
            return head;
        } else {
            slow.val++;
            slow = slow.next;
        }
        while (slow != null) {
            slow.val = 0;
            slow = slow.next;
        }
        return dummy.val == 0 ? dummy.next : dummy;
    }
*/
