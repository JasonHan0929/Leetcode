public class LRUCache {
    private class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode pre;
        
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            pre = null;
        }
    }
    
    HashMap<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity;
    int count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>(capacity);
    }
    
    private void add(ListNode node) {
        node.next = head.next;
        node.pre = head;
        head.next = node;
        node.next.pre = node;
    }
    
    private void remove(ListNode node) {
        ListNode pre = node.pre;
        ListNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }
    
    private void moveToHead (ListNode node) {
        remove(node);
        add(node);
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            moveToHead(map.get(key));
            return map.get(key).value;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (count >= capacity) {
                map.remove(tail.pre.key);
                remove(tail.pre);
            }
            else
                count++;
            ListNode node = new ListNode(key, value);
            add(node);
            map.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
The problem can be solved with a hashtable that keeps track of the keys and its values in the double linked list. One interesting property about double linked list is that the node can remove itself without other reference. In addition, it takes constant time to add and remove nodes from the head or tail.

One particularity about the double linked list that I implemented is that I create a pseudo head and tail to mark the boundary, so that we don't need to check the NULL node during the update. This makes the code more concise and clean, and also it is good for the performance as well.

Voila, here is the code.

*/
