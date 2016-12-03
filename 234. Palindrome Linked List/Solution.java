/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        
        ListNode next = slow;
        ListNode prev = null;
        while(next != null) {
            ListNode tempo = next.next;
            next.next = prev;
            prev =next;
            next = tempo;
        }
        
        ListNode tailHead = prev;
        while (tailHead != null) {
            if(head.val != tailHead.val)
                return false;
            head = head.next;
            tailHead = tailHead.next;
        }
        return true;
    }
}

//declare function to simplify the code
