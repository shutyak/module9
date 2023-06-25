import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyQueueTest {
    private MyQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new MyQueue();
    }

    @Test
    public void testAdd() {
        queue.add("Element 1");
        queue.add("Element 2");

        Assertions.assertEquals(2, queue.size());
        Assertions.assertEquals("Element 1", queue.peek());
    }

    @Test
    public void testClear() {
        queue.add("Element 1");
        queue.add("Element 2");

        queue.clear();

        Assertions.assertEquals(0, queue.size());
        Assertions.assertThrows(IllegalStateException.class, () -> queue.peek());
    }

    @Test
    public void testPoll() {
        queue.add("Element 1");
        queue.add("Element 2");

        Object firstElement = queue.poll();

        Assertions.assertEquals(1, queue.size());
        Assertions.assertEquals("Element 1", firstElement);
        Assertions.assertEquals("Element 2", queue.peek());
    }
}
