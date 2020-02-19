class Node {
    Node pre;
    Node next;
    int val;

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next, Node pre) {
        this.val = val;
        this.next = next;
        this.pre = pre;
    }
}

class MyLinkedList {
    private Node dummyHead;
    private Node dummyTail;
    //int size; 用来正反搜索加快速度

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.dummyHead = new Node(-1);
        this.dummyTail = new Node(-1);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        //this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node cur = dummyHead.next;
        while (index > 0 && cur != dummyTail) {
            index--;
            cur = cur.next;
        }
        return cur == dummyTail ? -1 : cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node head = new Node(val, dummyHead.next, dummyHead);
        dummyHead.next = head;
        head.next.pre = head;
        return;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node tail = new Node(val, dummyTail, dummyTail.pre);
        dummyTail.pre = tail;
        tail.pre.next = tail;
        return;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node cur = dummyHead.next;
        while (index > 0 && cur != null) {
            index--;
            cur = cur.next;
        }
        if (cur == null) {
            return;
        }
        Node newNode = new Node(val, cur, cur.pre);
        cur.pre = newNode;
        newNode.pre.next = newNode;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node cur = dummyHead.next;
        while (index > 0 && cur != dummyTail) {
            index--;
            cur = cur.next;
        }
        if (cur == dummyTail) {
            return;
        }
        cur.next.pre = cur.pre;
        cur.pre.next = cur.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
