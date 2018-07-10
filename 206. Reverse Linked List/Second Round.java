class Solution {
10
    public ListNode reverseList(ListNode head) {
11
        // return recursive(null, head);
12
        return literative(head);
13
    }
14
    
15
    public ListNode recursive(ListNode head, ListNode next) {
16
        if (next == null) return head;
17
        ListNode newNext = next.next;
18
        next.next = head;
19
        return recursive(next, newNext);
20
    }
21
    
22
    public ListNode literative(ListNode head) {
23
        ListNode pre = null;
24
        ListNode cur = head;
25
        while (cur != null) {
26
            ListNode temp = cur.next;
27
            cur.next = pre;
28
            pre = cur;
29
            cur = temp;
30
        }
31
        return pre;
32
    }
33
}
