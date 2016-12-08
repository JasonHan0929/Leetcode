/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        Set<ListNode> hash = new HashSet<>();
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;//注意快慢指针的赋值方式，不是fast = slow.next
            if (slow == fast) {
                while (!hash.contains(slow)) {
                    hash.add(slow);
                    slow = slow.next;
                }
                slow = head;
                while (slow != null) {
                    if (hash.contains(slow))
                        return slow;
                    slow = slow.next;
                }
            }//找到环后靠hashset来判断环的第一个节点
        }
        return null;
    }
}//繁琐版,空间复杂度On

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}//牛人套路版，用数学计算省去多余空间

/*相关算法
1). 使用快慢指针法，若链表中有环，可以得到两指针的交点M

2). 记链表的头节点为H，环的起点为E

2.1) L1为H到E的距离
2.2) L2为从E出发，首次到达M时的路程
2.3) C为环的周长
2.4) n为快慢指针首次相遇时，快指针在环中绕行的次数

根据L1,L2和C的定义，我们可以得到：

慢指针行进的距离为L1 + L2

快指针行进的距离为L1 + L2 + n * C

由于快慢指针行进的距离有2倍关系，因此：

2 * (L1+L2) = L1 + L2 + n * C => L1 + L2 = n * C => L1 = (n - 1)* C + (C - L2)

可以推出H到E的距离 = 从M出发绕环到达E时的路程

因此，当快慢指针在环中相遇时，我们再令一个慢指针从头节点出发

接下来当两个慢指针相遇时，即为E所在的位置*/