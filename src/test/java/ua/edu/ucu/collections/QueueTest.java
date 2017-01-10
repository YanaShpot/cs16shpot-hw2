package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testSimpleEnqueueAndDequeue() {
        int a = 1;

        Queue queue = new Queue();
        queue.enqueue(a);
        queue.enqueue(2);
        int res = (Integer) queue.dequeue();
        assertEquals(a, res);
    }

    @Test
    public void testComplicatedEnqueueAndDequeue() {
        int a = 1;
        int b = 2;
        Queue queue = new Queue();
        queue.enqueue(a);
        queue.enqueue(b);
        queue.dequeue();
        int res = (Integer) queue.dequeue();
        assertEquals(b, res);
    }

    @Test
    public void testPeek() {
        int a = 1;
        int b = 2;
        Queue queue = new Queue();
        queue.enqueue(a);
        queue.enqueue(b);
        int res = (Integer) queue.peek();
        assertEquals(a, res);}
}