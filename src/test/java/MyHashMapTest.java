import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyHashMapTest {
    private MyHashMap map;

    @BeforeEach
    public void setUp() {
        map = new MyHashMap();
    }

    @Test
    public void testPutAndGet() {
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertEquals("value1", map.get("key1"));
        assertEquals("value2", map.get("key2"));
        assertEquals("value3", map.get("key3"));
    }

    @Test
    public void testPutDuplicateKey() {
        map.put("key1", "value1");
        map.put("key1", "value2");

        assertEquals("value2", map.get("key1"));
    }

    @Test
    public void testRemove() {
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        map.remove("key2");

        assertNull(map.get("key2"));
        assertEquals(2, map.size());
    }

    @Test
    public void testClear() {
        map.put("key1", "value1");
        map.put("key2", "value2");

        map.clear();

        assertNull(map.get("key1"));
        assertNull(map.get("key2"));
        assertEquals(0, map.size());
    }

    @Test
    public void testSize() {
        assertEquals(0, map.size());

        map.put("key1", "value1");
        map.put("key2", "value2");

        assertEquals(2, map.size());

        map.remove("key1");

        assertEquals(1, map.size());

        map.clear();

        assertEquals(0, map.size());
    }
}
