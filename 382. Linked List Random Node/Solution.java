/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    ListNode head;
    Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int r = head.val;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            if (random.nextInt(count + 1) == count)
                r = cur.val;
            count++;
            cur = cur.next;
        }
        return r;
    }
}//注意这个解法其实和蓄水池取样是有区别的，至少看起来是不一样的

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

/*
When I first got this question, I went through some articles, but it is painful for me to understand abstract notations like i, k, m, n, n-1, k+1...

After I read this one: http://blog.jobbole.com/42550/, it comes with a simple example and I understood suddenly, and write the code by myself. I translate it to English, so more people can benefit from it.

Start...
When we read the first node "head", if the stream "ListNode" stops here, we can just return the head.val. The possibility is 1/1.

When we read the second node, we can decide if we replace the result 'r' or not. The possibility is 1/2. So we just generate a random number between 0 and 1, and check if it is equal to 1. If it is 1, replace 'r' as the value of the current node, otherwise we don't touch 'r', so its value is still the value of head.

When we read the third node, now the result 'r' is one of value in the head or second node. We just decide if we replace 'the value of r' as 'the value of current node(third node)'. The possibility of replacing it is 1/3, namely the possibility of we don't touch r is 2/3. So we just generate a random number between 0 ~ 2, and if the result is 2 we replace 'r'.

We can continue to do like this until the end of stream "ListNode".

Here is the Java code:

public class Solution {
    
    ListNode head;
    Random random;
    
    public Solution(ListNode head) {
        this.head = head;                
    }
    
    public int getRandom() {
        
        ListNode c = head;
        int r = c.val;
        for(int i=1;c.next != null;i++){
            
            c = c.next;
            if(randInt(0,i) == i) r = c.val;                        
        }
        
        return r;
    }
    
    private int randInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
*/
