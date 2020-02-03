public class Vector2D implements Iterator<Integer> {
    
    int listIndex = 0;
    int elementIndex = 0;
    List<List<Integer>> vec2d;
    
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        while (listIndex < vec2d.size() && vec2d.get(listIndex).size() == 0) 
            listIndex++;
    }

    @Override
    public Integer next() {
        int result = vec2d.get(listIndex).get(elementIndex);
        elementIndex++;
        if (elementIndex == vec2d.get(listIndex).size()) {
            elementIndex = 0;
            listIndex++;
            while (listIndex < vec2d.size() && vec2d.get(listIndex).size() == 0) 
                listIndex++;
        }        
        return result;
    }

    @Override
    public boolean hasNext() {
       return listIndex < vec2d.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class Vector2D implements Iterator<Integer> {
    Queue<Iterator<Integer>> queue = new LinkedList<>();
    
    public Vector2D(List<List<Integer>> vec2d) {
        for (List<Integer> list : vec2d) {
            if (list.size() > 0) queue.add(list.iterator());
        }
    }

    @Override
    public Integer next() {
        Iterator<Integer> cur = queue.peek();
        int result = cur.next();
        if (!cur.hasNext()) queue.poll();
        return result;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

