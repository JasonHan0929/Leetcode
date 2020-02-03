class LFUCache {

    private final int capacity;
    private int count = 0;
    private final Map<Integer, Integer> freqMap = new HashMap<>();
    private final Map<Integer, Node> cache = new HashMap<>();
    private final Map<Integer, DoubleLinkedList> lists = new HashMap<>();
    private int minFreq = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        System.out.println(key);
        Node node = cache.get(key);
        if (node == null) return -1;
        int freq = freqMap.get(key);
        DoubleLinkedList preList = lists.get(freq);
        preList.removeNode(node);
        if (preList.isEmpty()) {
            if (minFreq == freq) minFreq++;
            lists.remove(preList);
        }
        if (!lists.containsKey(freq + 1)) lists.put(freq + 1, new DoubleLinkedList());
        freqMap.put(key, freq + 1);
        lists.get(freq + 1).addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            get(key);
        } else {
            Node node = new Node(key, value);
            if (count < capacity) count++;
            else {
                DoubleLinkedList minList = lists.get(minFreq);
                cache.remove(minList.head.next.key);
                freqMap.remove(minList.head.next.key);
                minList.removeFirst();
                if(minList.isEmpty()) lists.remove(minFreq);
                
            }
            minFreq = 0;
            cache.put(key, node);
            freqMap.put(key, 0);
            if (!lists.containsKey(0)) lists.put(0, new DoubleLinkedList());
            lists.get(0).addNode(node);
        }
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
        addNextNode(tail.pre, node);
    }

    void addNextNode(Node cur, Node next) {
        next.next = cur.next;
        cur.next.pre = next;
        cur.next = next;
        next.pre = cur;
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

    boolean isEmpty() {
        return head.next == tail;
    }

} // very slow

/*
public class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int cap;
    int min = -1;
    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count+1);
        lists.get(count).remove(key);
        if(count==min && lists.get(count).size()==0)
            min++;
        if(!lists.containsKey(count+1))
            lists.put(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);
        return vals.get(key);
    }
    
    public void set(int key, int value) {
        if(cap<=0)
            return;
        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        } 
        if(vals.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}
*/

class LFUCache {

    private final int capacity;
    private int count = 0;
    private final Map<Integer, Integer> freqMap = new HashMap<>();
    private final Map<Integer, Integer> cache = new HashMap<>();
    private final Map<Integer, LinkedHashSet<Integer>> lists = new HashMap<>();
    private int minFreq = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        int freq = freqMap.get(key);
        LinkedHashSet<Integer> preList = lists.get(freq);
        preList.remove(key);
        if (preList.isEmpty()) {
            if (minFreq == freq) minFreq++;
            lists.remove(freq);
        }
        if (!lists.containsKey(freq + 1)) lists.put(freq + 1, new LinkedHashSet<Integer>());
        freqMap.put(key, freq + 1);
        lists.get(freq + 1).add(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            cache.put(key, value);
            get(key);
        } else {
            if (count < capacity) count++;
            else {
                LinkedHashSet<Integer> minList = lists.get(minFreq);
                int minKey = minList.iterator().next();
                cache.remove(minKey);
                freqMap.remove(minKey);
                minList.remove(minKey);
                if(minList.isEmpty()) lists.remove(minFreq);

            }
            minFreq = 0;
            cache.put(key, value);
            freqMap.put(key, 0);
            if (!lists.containsKey(0)) lists.put(0, new LinkedHashSet<Integer>());
            lists.get(0).add(key);
        }
    }
}
