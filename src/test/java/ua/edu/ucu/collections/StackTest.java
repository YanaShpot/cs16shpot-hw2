package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testSimplePushPop() {
        int a = 12;
        int b = 13;
        Stack stack = new Stack();
        stack.push(a);
        stack.push(b);
        int res = (Integer) stack.pop();
        assertEquals(b, res);
    }

    @Test
    public void testComplicatedPushPop() {
        int a = 12;
        int b = 13;
        Stack stack = new Stack();
        stack.push(a);
        stack.push(b);
        stack.pop();
        int res = (Integer) stack.pop();
        assertEquals(a, res);
    }

    @Test
    public void testPeek() {
        int a = 12;
        int b = 13;
        Stack stack = new Stack();
        stack.push(a);
        stack.push(b);
        int res = (Integer) stack.peek();
        assertEquals(b, res);
    }

}