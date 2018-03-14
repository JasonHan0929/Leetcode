package Store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class implemented by ArrayList with a generic type paramter
 * It could not contains elements more than maxSize
 * It is used as a basic data structure of container by this library
 * It's public so that it could be resued in other circumstances
 */

public class Container<T> implements Iterable<T>, Serializable {

    private final List<T> list;
    private int maxSize;

    public Container(int maxSize) {
        list = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
    }

    public Container(Container container) {
        this.maxSize = container.getMaxSize();
        this.list = new ArrayList<>(container.getList());
    }

    private List<T> getList() {
        return list;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(T object) {
        return list.contains(object);
    }

    // do not append duplicate object
    private void append(T object) {
        if (contains(object)) return;
        list.add(object);
    }

    public void add(T... objects) {
        if (maxSize < objects.length + size()) {
            throw new RuntimeException("The container does not have enough space!");
        }
        for (T obj : objects) {
           append(obj);
        }
    }

    public void addAll(Container<T> other) {
        if (list.size() + other.size() > maxSize) {
            throw new RuntimeException("The container does not have enough space!");
        }
        list.addAll(other.getList());
    }

    public T get(int index) {
        if (index >= list.size()) {
            throw new RuntimeException("The index is out of range!");
        }
        return list.get(index);
    }

    public boolean remove(T object) {
        return list.remove(object);
    }

    public T remove(int index) {
        return list.remove(index);
    }

    public void clear() {
        list.clear();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

}
