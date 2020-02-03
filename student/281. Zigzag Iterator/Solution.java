public class ZigzagIterator {
    
    Deque<Iterator<Integer>> queue = new LinkedList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (v1.size() > 0) queue.offer(v1.iterator());
        if (v2.size() > 0) queue.offer(v2.iterator());
    }

    public int next() {
        Iterator<Integer> cur = queue.poll();
        int result = cur.next();
        if (cur.hasNext()) queue.offer(cur);
        return result;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

/*
 public class ZigzagIterator {

    private Iterator<Integer> i, j, tmp;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next() {
        if (j.hasNext()) { tmp = j; j = i; i = tmp; }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}
*/
