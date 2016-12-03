/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;//存在head更改的可能都要用dummy
        ListNode tempo;
        ListNode t;
        while (cur != null && cur.next != null) {
            if (cur.next.val < cur.val) {//涉及 cur.next != null都要有cur != null
                tempo = dummy;
                while (tempo != cur) {
                    if (tempo.next.val > cur.next.val) {
                        t = cur.next.next;
                        cur.next.next = tempo.next;
                        tempo.next = cur.next;
                        cur.next = t;
                        break;
                    }
                    tempo = tempo.next;
                }
            }
            else
                cur = cur.next;//注意在进行从头插入的过程后cur不用移动
        }
        return dummy.next;
    }
}//没必要维护一个指针只想排好序的序列的结尾，不然会超时
