public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode slow =fakeHead;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val == val)
                slow.next = fast.next;
            else
                slow = slow.next;
            fast = fast.next;
        }
        return fakeHead.next;
    }
}
