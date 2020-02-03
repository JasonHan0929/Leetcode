public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        this(x);
        this.next = next;
    }

    public static ListNode makeLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int val : arr) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static String toString(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head.next != null) {
            builder.append(head.val);
            builder.append(",");
            head = head.next;
        }
        builder.append(head.val);
        return builder.toString();
    }

    public static String toString(ListNode head, ListNode tail) {
        StringBuilder builder = new StringBuilder();
        while (head.next != tail) {
            builder.append(head.val);
            builder.append(",");
            head = head.next;
        }
        builder.append(head.val);
        return builder.toString();
    }

    public static String toString(ListNode head, int len) {
        StringBuilder builder = new StringBuilder();
        while (head.next != null && len > 1) {
            builder.append(head.val);
            builder.append(",");
            head = head.next;
        }
        builder.append(head.val);
        return builder.toString();
    }
}
