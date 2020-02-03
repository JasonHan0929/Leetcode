/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode left = head;
        ListNode right = head.next;
        ListNode tail = left;
        while (right != null) {
            if (left == head)
                head = right;
            tail.next = right;
            left.next = right.next;
            right.next = left;
            tail = left;
            if (left != null)
                left = left .next;
            else
                break;
            if (left != null)
                right = left.next;
            else
                break;
        }
        return head;
    }
}//巨复杂版，两个指针不行，一定要三个指针

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode left = head;
        ListNode right = head.next;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        while (right != null && left != null) {
            tail.next = right;
            left.next = right.next;
            right.next = left;
            tail = left;
            left = left .next;
            if (left != null)
                right = left.next;
            else
                break;
        }
        return dummy.next;
    }
}//略简化版

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode left = head;
        ListNode right = head.next;
        left.next = right.next;
        right.next = left;
        head = right;
        if (left.next != null)
            left.next = swapPairs(left.next);
        return head;
    }
}//递归版，更简洁

//以下都是指针用的牛逼的版本好好学习
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}

T tusizi 
Reputation:  1,213
 public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode current = dummy;
    while (current.next != null && current.next.next != null) {
        ListNode first = current.next;
        ListNode second = current.next.next;
        first.next = second.next;
        current.next = second;
        current.next.next = first;
        current = current.next.next;
    }
    return dummy.next;
}

