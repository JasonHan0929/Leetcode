class LRUCache {
    
    private final Map<Integer, Node> cache = new HashMap<>();
    private DoubleLinkedList list = new DoubleLinkedList();
    private final int capacity;
    private int count = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        list.moveToEnd(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key))  {
            cache.get(key).value = value;
            list.moveToEnd(cache.get(key));
            return;
        }
        Node node = new Node(key, value);
        list.addNode(node);
        cache.put(key, node);
        if (count == capacity) {
            cache.remove(list.head.next.key);
            list.removeFirst();
        }
        else count++;
    }
}

class Node {
    
    int key, value;
    Node next, pre;
    
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleLinkedList {
    
    Node head, tail;
    
    DoubleLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }
    
    void addNode(Node node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }
    
    void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    void moveToEnd(Node node) {
        removeNode(node);
        addNode(node);
    }
    
    void removeFirst() {
        removeNode(head.next);
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


/*
his is the laziest implementation using Java's LinkedHashMap. In the real interview, however, it is definitely not what interviewer expected.

    import java.util.LinkedHashMap;
    public class LRUCache {
        private LinkedHashMap<Integer, Integer> map;
        private final int CAPACITY;
        public LRUCache(int capacity) {
            CAPACITY = capacity;
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > CAPACITY;
                }
            };
        }
        public int get(int key) {
            return map.getOrDefault(key, -1);
        }
        public void set(int key, int value) {
            map.put(key, value);
        }
    }
Several points to mention:

In the constructor, the third boolean parameter specifies the ordering mode. If we set it to true, it will be in access order. (https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#LinkedHashMap-int-float-boolean-)
By overriding removeEldestEntry in this way, we do not need to take care of it ourselves. It will automatically remove the least recent one when the size of map exceeds the specified capacity.(https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#removeEldestEntry-java.util.Map.Entry-)
Below is a "normal" HashMap + doubly-linked list implementation:

public class LRUCache {
    private class Node{
        int key, value;
        Node prev, next;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
        Node(){
            this(0, 0);
        }
    }
    private int capacity, count;
    private Map<Integer, Node> map;
    private Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(null==n){
            return -1;
        }
        update(n);
        return n.value;
    }
    
    public void set(int key, int value) {
        Node n = map.get(key);
        if(null==n){
            n = new Node(key, value);
            map.put(key, n);
            add(n);
            ++count;
        }
        else{
            n.value = value;
            update(n);
        }
        if(count>capacity){
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
            --count;
        }
    }
    
    private void update(Node node){
        remove(node);
        add(node);
    }
    private void add(Node node){
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }
    
    private void remove(Node node){
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }
}
*/
