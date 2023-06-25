import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyStackTest {
    private MyStack stack;

    @BeforeEach
    public void setUp() {
        stack = new MyStack();
    }

    @Test
    public void testPushAndPop() {
        stack.push("Element 1");
        stack.push("Element 2");

        Assertions.assertEquals(2, stack.size());
        Assertions.assertEquals("Element 2", stack.pop());
        Assertions.assertEquals(1, stack.size());
        Assertions.assertEquals("Element 1", stack.peek());
    }

    @Test
    public void testRemove() {
        stack.push("Element 1");
        stack.push("Element 2");
        stack.push("Element 3");

        stack.remove(1);

        Assertions.assertEquals(2, stack.size());
        Assertions.assertEquals("Element 3", stack.pop());
        Assertions.assertEquals("Element 1", stack.peek());
    }

    @Test
    public void testClear() {
        stack.push("Element 1");
        stack.push("Element 2");

        stack.clear();

        Assertions.assertEquals(0, stack.size());
        Assertions.assertThrows(IllegalStateException.class, () -> stack.peek());
    }
}
