package Store;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Store {

    // the only container in this library, similar as a singleton
    private final static Container<Object> container = new Container<>(10); // default maxSize is 10

    public static void setMaxSize(int maxSize) {
        container.setMaxSize(maxSize);
    }

    public static int getMaxSize() {
        return container.getMaxSize();
    }

    // store element in container(in main memory)
    public static void store(Object... objects) {
        container.add(objects);
    }

    // generic method, it will cast the return object for your variable type automatically
    public static <T> T get(int index) {
        Object result = container.get(index);
        return (T)result;
    }

    public static <T> List<T> getAll() {
        List<T> result = new ArrayList<>(size());
        for (Object o : container) {
            result.add((T)o);
        }
        return result;
    }

    public static int size() {
        return container.size();
    }

    public static boolean contains(Object objecct) {
        return container.contains(objecct);
    }

    public static boolean remove(Object object) {
        return container.remove(object);
    }

    public static <T> T remove(int index) {
        return (T)container.remove(index);
    }

    public static void clear() {
        container.clear();
    }

    // serialize the container into disk so that you could store it after jvm stoppoing
    public static void serialize(String fileName) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(fileName))
        )) {
            out.writeObject(container);
            out.flush();
            out.close();
        }
    }

    // read serialized object from disk so that you could reuse them
    public static void readSerializedObjects(String fileName) throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(
            new BufferedInputStream(new FileInputStream(fileName))
        )) {
            Container<Object> temp = (Container<Object>)in.readObject();
            in.close();
            container.clear();
            container.addAll(temp);
        }
    }
}

/*
My Though about the design process:
  1. Data Structure:
      As you only wanna to store up to 10 objects, the most straightfoward data structure you could use is a list. I choose arraylist in this library.
  2. How it Work:
      There is a single static Container<Object> instance in Store class. Every time you add elements into this container by Store.store() method, it will check duplicate and the available space. This container will not store duplicate element and could not store more once it reeach the max size. So when the container is full, unless you remove element or clear the container, you could not use this container again. The max size has a default value 10, and you could reset this value bye setMaxsize() method.
  3.  About Type:
      This library use an Container<Object> to contains the element you want to store. So basically it could store objects from different class in same time. But this is not encouraged. Because you have to know the objects' class when you get the object. As java, not like python, is a statically-typed language, you have to declar the type of an variavle before you could use it. So unless you could remember the specific type of every element in this container, you'd better only store elements for one type.
      Using Container<Object> to store any objects instead of giving a constrain on element type is to improve the reusability of this library. Because for one time you may wanna store Integer in this library, but for another time, you may wanna store Double. Using Container<Object> will give you a common interface and a better usability.
      And in another way, the get method is a generic method, which means it will automatically cast the object from Object to which you want most of the time. For example, if you know the element you wanna get is Integer, then you could write 'Integer element = Store.get(i)' or 'integer[] elements = Store.getAll()' and then it will give what you want. But you have to give the valid type of a particular element, otherwise an exception will be raised.
  4. About store:
      Well, the quesition about store is kind of ambiguous because it only says you wannt store these elements but does not mention you wanna store them in main memory or in disk. So I implement both. That is, you could only store those elements in container in main memory for re-access. And you could also serialize the container into your disk so that you could read and reuse them for next time even when jvm stops. To use serialize method, you should maintain that all the elements into current container is Serializable. Otherwise error will happen.
      When you read the serialized data from disk, the containter in this library, which is the only container you have, will be refreshed by those data. You will get a container only has the data you saved in your disk. That means you will lose what you have in main memory in this container. So if you need what you have currently, save it first before you read anything.
  5. About the Size:
      I'm not sure why the question mention the size of this objects. Becuase you only store an reference about every element, it will not cost too much memory even though the object is about 80M. And for large object, it might need some smart algorithm to improve the serialize process. But 80M is not such a big that I think a normal serialize process will stillwork. Maybe it will take some times to write into your disk but I think it will be done within one minutes once you have a SSD.
  5. Test
      Test code could be found in ../test/StoreTest.java using Junit4.
*/