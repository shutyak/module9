import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyLinkedListTest {
    private MyLinkedList list;

    @BeforeEach
    public void setUp() {
        list = new MyLinkedList();
    }

    @Test
    public void testAdd() {
        list.add("Element 1");
        list.add("Element 2");

        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("Element 1", list.get(0));
        Assertions.assertEquals("Element 2", list.get(1));
    }

    @Test
    public void testRemove() {
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        list.remove(1);

        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("Element 1", list.get(0));
        Assertions.assertEquals("Element 3", list.get(1));
    }

    @Test
    public void testClear() {
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        list.clear();

        Assertions.assertEquals(0, list.size());
    }
}
