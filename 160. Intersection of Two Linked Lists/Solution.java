/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != currB) {//存在交点，则找到交点，不存在环则两个指针分别遍历一遍ListA和ListB后在等于null的地方相遇退出循环
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }
        return currA;
    }
}//思路知道以后代码也不是很好写，区分有没有交点比较复杂，所以用相遇就退出的方法判断

/*官方版：
蛮力法枚举（O(mn) 时间, O(1) 空间）

对于链表A中的每个节点ai，遍历整个链表B，检查B中是否有节点与ai重合

哈希表解法（O(n+m) 时间, O(n) or O(m) 空间）

遍历链表A并将每个节点的地址/引用存储在哈希表中。然后检查链表B中的每个节点bi：如果bi出现在哈希表中，则bi就是交点。

双指针解法 (O(n+m) 时间, O(1) 空间):

维护两个指针pA和pB，初始分别指向A和B。然后让它们分别遍历整个链表，每步一个节点。

当pA到达链表末尾时，让它指向B的头节点（没错，是B）；类似的当pB到达链表末尾时，重新指向A的头节点。

如果pA在某一点与pB相遇，则pA/pB就是交点。

下面来看下为什么这个算法可行，考虑两个链表：A = {1,3,5,7,9,11} B = {2,4,9,11}，它们的交点是节点'9'。由于B的长度是4 小于 A的长度6，pB会首先到达链表的末尾，由于pB比pA恰好少走2个节点。通过把pB指向A的头，把pA指向B的头，我们现在让pB比pA恰好多走2个节点。所以在第二轮，它们可以保证同时在交点相遇。

如果两个链表有交点，则它们的最后一个节点一定是同一个节点。所以当pA/pB到达链表末尾时，分别记录下A和B的最后一个节点。如果两个链表的末尾节点不一致，说明两个链表没有交点。

本人解题思路：
将链表A的末尾节点endA指向B的头结点headB

交点存在性的判断：
如果此时的链表中存在环路，则说明两个链表相交

交点的确定：
pA指针从headA出发，向前走lenB步（链表B的长度）

将pB指针指向headA，令pA和pB同时向前行进（每次一步），记下它们首次相遇的位置，即为链表的交点

原理：
当pA与pB相遇时，pA恰好比pB领先一个整环的长度(lenB)*/
