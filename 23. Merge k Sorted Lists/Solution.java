/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int n = lists.length;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(n, (x, y) -> x.val - y.val);
        for (int i = 0; i < n; i++) {
            if (lists[i] != null)
                heap.add(lists[i]);
        }
        while (!heap.isEmpty()) {
            curr.next = heap.poll();
            curr = curr.next;
            if (curr.next != null)
                heap.add(curr.next);
        }
        curr.next = null;
        return dummy.next;
    }
}
