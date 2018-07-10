class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n == m) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        ListNode start = null;
        ListNode temp = null;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        start = pre;
        cur = cur.next;
        pre = pre.next;
        for (int i = m + 1; i <=n; i++) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        temp = start.next;
        start.next = pre;
        temp.next = cur;
        return dummy.next;
    }
}
