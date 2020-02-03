import static  org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
import Store.Store;

public class StoreTest {

    @Test
    public void testSetMaxsizeAndGetMaxsizeMethods() {
        int origin = Store.getMaxSize();
        Store.setMaxSize(origin + 1);
        assertTrue("Maxsize plus 1", Store.getMaxSize() == origin + 1);
        Store.setMaxSize(origin);
    }

    @Test
    public void testStoreAndContainsMethod() {
        Integer[] a = new Integer[] {new Integer(1), new Integer(2)};
        Double b = new Double(5.5);
        Store.store(a);
        Store.store(b);
        assertTrue(Store.contains(b));
        assertTrue(Store.contains(a[1]));
        assertTrue(Store.contains(a[0]));
        Store.clear();
    }

    @Test
    public void testGetAndSizeMethods() {
        Store.store(new Integer(1), new Integer(2));
        Integer a = Store.get(1);
        assertTrue(a == 2);
        List<Integer> b = Store.getAll();
        assertTrue(b.contains(1));
        assertTrue(b.contains(2));
        assertTrue(b.size() == Store.size());
        Store.clear();
    }

    @Test
    public void testRemoveMethod() {
        Store.store(new Integer(1), new Integer(2));
        assertTrue(Store.<Integer>remove(1) == 2);
        assertTrue(Store.remove(new Integer(1)));
        Store.clear();
    }

    @Test
    public void testSerializeAndReadMethod() throws Exception {
        Store.store(new Integer(1), new Integer(2));
        Store.serialize("./store.out");
        Store.store(new Integer(3));
        Store.readSerializedObjects("./store.out");
        assertTrue(Store.contains(new Integer(1)));
        assertTrue(Store.contains(new Integer(2)));
        assertFalse(Store.contains(new Integer(3)));
    }
}
