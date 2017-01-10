package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void testAdd() {
        ImmutableLinkedList list= new ImmutableLinkedList();
        Object[] expectedResult = {1, 2, 3};
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);

        Object[] actualResult = list.toArray();
        assertArrayEquals(expectedResult, actualResult);

    }

    @Test
    public void testAddWithIndex() {
        ImmutableLinkedList list= new ImmutableLinkedList();
        Object[] expectedResult = {1,0, 2, 3};
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);
        list = list.add(1,0);
        Object[] actualResult = list.toArray();

        assertArrayEquals(expectedResult, actualResult);

    }

    @Test
    public void testAddFirstAndAddLast() {
        ImmutableLinkedList list= new ImmutableLinkedList();
        Object[] expectedResult = {0,1, 2, 3};
        list = list.addFirst(1);
        list = list.add(2);
        list = list.addFirst(0);
        list = list.addLast(3);
        Object[] actualResult = list.toArray();

        assertArrayEquals(expectedResult, actualResult);

    }

    @Test
    public void testAddAll() {
        ImmutableLinkedList list= new ImmutableLinkedList();
        Object[] obj = new Object[]{0,1,2,3};
        Object[] expectedResult = {0,1,2,3};
        list = list.addAll(obj);
        Object[] actualResult = list.toArray();

        assertArrayEquals(expectedResult, actualResult);

    }

    @Test
    public void testAddAllWithIndex() {
        ImmutableLinkedList list= new ImmutableLinkedList();
        Object[] obj = new Object[]{1,2,3};
        list = list.addAll(new Object[]{4});
        list = list.addAll(0,new Object[]{0});
        Object[] expectedResult = {0,1,2,3,4};
        list = list.addAll(1,obj);
        Object[] actualResult = list.toArray();

        assertArrayEquals(expectedResult, actualResult);

    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddElementWithIndexException() {
        String expectedResult = "";
        ImmutableLinkedList list = new ImmutableLinkedList();
        int[] values = new int[]{34, 65, 18};
        for (int i = 0; i < 3; i++) {
            list = list.add(values[i]);
        }
        list = list.add(1093, 4678);

        assertEquals(new IndexOutOfBoundsException(), list);
    }

    @Test
    public void testGet() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        int[] values = new int[]{1, 2, 3, 4};
        for (int i = 0; i < 4; i++) {
            list = list.add(values[i]);
        }
        Object result = list.get(1);

        assertEquals("2", result.toString());
    }

    @Test
    public void testGetFirst() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        int[] values = new int[]{1, 2, 3, 4};
        for (int i = 0; i < 4; i++) {
            list = list.add(values[i]);
        }
        Object result = list.getFirst();

        assertEquals("1", result.toString());
    }

    @Test
    public void testGetLast() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        int[] values = new int[]{1, 2, 3, 4};
        for (int i = 0; i < 4; i++) {
            list = list.add(values[i]);
        }
        Object result = list.getLast();

        assertEquals("4", result.toString());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        int[] values = new int[]{1, 2, 3, 4};
        for (int i = 0; i < 4; i++) {
            list = list.add(values[i]);
        }
        Object result = list.get(567);

        assertEquals(new IndexOutOfBoundsException(), result);
    }

    @Test
    public void testSet() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        String expectedResult = "ImmutableLinkedList:\n1, 4, 3, 4";
        int[] values = new int[]{1, 2, 3, 4};
        for (int i = 0; i < 4; i++) {
            list = list.add(values[i]);
        }
        list = list.set(1, 4);

        assertEquals(expectedResult, list.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setException() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        int[] values = new int[]{1, 2, 3, 4};
        for (int i = 0; i < 4; i++) {
            list = list.add(values[i]);
        }
        list = list.set(-1, 1234);

        assertEquals(new IndexOutOfBoundsException(), list);
    }


    @Test
    public void testClear() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        int[] values = new int[]{1, 2, 3, 4};
        for (int i = 0; i < 4; i++) {
            list = list.add(values[i]);
        }
        list = list.clear();

        assertEquals(new ImmutableLinkedList().toString(), list.toString());
    }

    @Test
    public void testIsEmpty() {
        boolean expectedResult = false;
        ImmutableLinkedList list = new ImmutableLinkedList(new Node (0,null));
        boolean result = list.isEmpty();

        assertEquals(expectedResult, result);

        ImmutableLinkedList newLinkedList1 = new ImmutableLinkedList();
        expectedResult = true;
        result = newLinkedList1.isEmpty();

        assertEquals(expectedResult, result);

    }

    @Test
    public void testRemoveAndRemoveLast() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        Object[] expectedResult = {1, 2};
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);
        ImmutableLinkedList list1 = list.removeLast();
        ImmutableLinkedList list2 = list.remove(2);

        assertArrayEquals(expectedResult, list1.toArray());
        assertArrayEquals(expectedResult, list2.toArray());
    }


    @Test
    public void testRemoveAndRemoveFirst() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        Object[] expectedResult1 = {2, 3};
        Object[] expectedResult2 = {1, 3};
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);
        ImmutableLinkedList list1 = list.removeFirst();
        ImmutableLinkedList list2 = list.remove(1);

        assertArrayEquals(expectedResult1, list1.toArray());
        assertArrayEquals(expectedResult2, list2.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        int[] values = new int[]{1, 2, 3, 4};
        for (int i = 0; i < 4; i++) {
            list = list.add(values[i]);
        }
        list = list.remove(456);

        assertEquals(new IndexOutOfBoundsException(), list);
    }

    @Test
    public void testIndexOf() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        int[] values = new int[]{1, 2, 3, 4};
        for (int i = 0; i < 4; i++) {
            list = list.add(values[i]);
        }
        int expectedResult = 1;
        int expectedResultWithException = -1;
        int result = list.indexOf(2);
        int resultWithException = list.indexOf(100000);

        assertEquals(expectedResult, result);
        assertEquals(expectedResultWithException, resultWithException);
    }

    @Test
    public void testSize() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        int[] values = new int[]{1, 2, 3, 4};
        for (int i = 0; i < 4; i++) {
            list = list.add(values[i]);
        }

        assertEquals(4, list.size());
    }
    
    @Test
    public void testToString() {
        String expectedResult = "ImmutableLinkedList:\n1, 2, 3, 4";
        ImmutableLinkedList list = new ImmutableLinkedList();
        int[] values = new int[]{1, 2, 3, 4};
        for (int i = 0; i < 4; i++) {
            list = list.add(values[i]);
        }

        assertEquals(expectedResult, list.toString());
    }


}