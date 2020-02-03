import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for Serialize Class.
 */
public class SerializeTest {
    private Serialize serialize = new Serialize();

    @Test(expected=InvalidParameterException.class)
    public void testSaveWhenInputISNull() {
        serialize.save(null);
    }

    @Test(expected=InvalidParameterException.class)
    public void testSaveWhenInputListContiansNull() {
        List<Map<String, String>> list = new ArrayList<>();
        list.add(null);
        list.add(new HashMap<>());
        serialize.save(list);
    }

    @Test
    public void testSaveWhenInputIsEmpty() {
        assertEquals(serialize.save(new ArrayList<>()), "");
    }

    @Test
    public void testSaveWhenInputHasEmptyMap() {
        List<Map<String, String>> list = new ArrayList<>();
        list.add(new HashMap<>());
        list.add(new HashMap<>());
        list.get(0).put("k", "v");
        assertEquals("k=v\n", serialize.save(list));
    }

    @Test
    public void testSaveWithNormalInput() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("k1", "v1");
        map1.put("k2", "v2");
        Map<String, String> map2 = new HashMap<>();
        map2.put("A", "XXX");
        list.add(map1);
        list.add(map2);
        assertEquals("k1=v1;k2=v2\nA=XXX", serialize.save(list));
    }

    @Test
    public void testSaveWithTrickyInput() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("k1", "\nv1");
        map1.put("\\\nk2", "v2");
        Map<String, String> map2 = new HashMap<>();
        map2.put("A", "XXX");
        list.add(map1);
        list.add(map2);
        assertEquals("k1=\\nv1;\\\\nk2=v2\nA=XXX", serialize.save(list));
    }

    @Test(expected=InvalidParameterException.class)
    public void testLoadWhenInputIsNull() {
        serialize.load(null);
    }

    @Test
    public void testLoadWithEmptyInput() {
        assertEquals(new ArrayList<Map<String, String>>(), serialize.load(""));
    }

    @Test
    public void testLoadWithEmptyLine() {
        List<Map<String, String>> list = new ArrayList<>();
        list.add(new HashMap<>());
        list.add(new HashMap<>());
        assertEquals(list, serialize.load("\n\n"));
    }

    @Test
    public void testLoadwithNormalInput() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("k1", "v1");
        map1.put("k2", "v2");
        Map<String, String> map2 = new HashMap<>();
        map2.put("A", "XXX");
        list.add(map1);
        list.add(map2);
        assertEquals(list, serialize.load("k1=v1;k2=v2\nA=XXX"));
    }

    @Test
    public void testLoadWithTrickyInput() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("k1", "\nv1");
        map1.put("\\\nk2", "v2");
        Map<String, String> map2 = new HashMap<>();
        map2.put("A", "XXX");
        list.add(map1);
        list.add(map2);
        assertEquals(list, serialize.load("k1=\\nv1;\\\\nk2=v2\nA=XXX"));
    }

    @Test
    public void testLoadAndSave() {
        String text = "abcd=1\n\nes=\\n2";
        List<Map<String, String>> list = serialize.load(text);
        String str = serialize.save(list);
        assertEquals(text, str);
    }
}
