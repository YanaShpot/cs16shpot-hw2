package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testAdd() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3});
        arrayList = arrayList.add(4);
        Object expectedResult = new ImmutableArrayList(new Object[]{1, 2, 3, 4}).toString();
        assertEquals(expectedResult, arrayList.toString());
    }

    @Test
    public void testAddToEmpty() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{});
        arrayList = arrayList.add(4);
        Object expectedResult = new ImmutableArrayList(new Object[]{4}).toString();
        assertEquals(expectedResult, arrayList.toString());
    }

    @Test
    public void testAddWithIndexToEmpty() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{});
        arrayList = arrayList.add(0, 4);
        Object expectedResult = new ImmutableArrayList(new Object[]{4}).toString();
        assertEquals(expectedResult, arrayList.toString());
    }

    @Test
    public void testAddWithIndex() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 5, 6, 7});
        arrayList = arrayList.add(3, 4);
        Object expectedResult = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5, 6, 7}).toString();
        assertEquals(expectedResult, arrayList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexTooBigException() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        arrayList = arrayList.add(100, 4);
        assertEquals(new IndexOutOfBoundsException(), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexTooSmallException() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        arrayList = arrayList.add(-1, 4);
        assertEquals(new IndexOutOfBoundsException(), arrayList);
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        arrayList = arrayList.addAll(new Object[]{5, 6, 7});
        Object expectedResult = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5, 6, 7}).toString();
        assertEquals(expectedResult, arrayList.toString());
    }

    @Test
    public void testAddAllToEmpty() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{});
        arrayList = arrayList.addAll(new Object[]{5, 6, 7});
        Object expectedResult = new ImmutableArrayList(new Object[]{5, 6, 7}).toString();
        assertEquals(expectedResult, arrayList.toString());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexTooSmall() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        arrayList = arrayList.addAll(-1, new Object[]{5, 6, 7});
        assertEquals(new IndexOutOfBoundsException(), arrayList);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexTooBigException() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3});
        arrayList = arrayList.addAll(234, new Object[]{4, 5, 6});
        assertEquals(new IndexOutOfBoundsException(), arrayList);

    }

    @Test
    public void testGet() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3});
        assertEquals(2, arrayList.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetTooSmallIndexException() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3});
        assertEquals(new IndexOutOfBoundsException(), arrayList.get(-1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetTooBigIndexException() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3});
        assertEquals(new IndexOutOfBoundsException(), arrayList.get(456));
    }

    @Test
    public void testRemove() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5, 6, 7});
        arrayList = arrayList.remove(3);
        Object expectedResult = new ImmutableArrayList(new Object[]{1, 2, 3, 5, 6, 7}).toString();
        assertEquals(expectedResult, arrayList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveTooSmallIndexException() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5, 6, 7});
        arrayList = arrayList.remove(-1);
        assertEquals(new IndexOutOfBoundsException(), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveTooBigIndexException() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5, 6, 7});
        arrayList = arrayList.remove(123);
        assertEquals(new IndexOutOfBoundsException(), arrayList.toString());
    }

    @Test
    public void testSet() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5, 6, 7});
        arrayList = arrayList.set(2, -1);
        assertEquals(-1, arrayList.getValue()[2]);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetTooSmallIndexException() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5, 6, 7});
        arrayList = arrayList.set(-1, 8);
        assertEquals(new IndexOutOfBoundsException(), arrayList);
    }

    @Test
    public void testIndexOf() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5});
        assertEquals(4, arrayList.indexOf(5));
    }

    @Test
    public void testIndexOfEmpty() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5});
        assertEquals(-1, arrayList.indexOf(1000));
    }

    @Test
    public void testSize() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5});
        assertEquals(5, arrayList.size());
    }

    @Test
    public void testClear() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5});
        arrayList = arrayList.clear();
        assertArrayEquals(null, arrayList.getValue());
    }

    @Test
    public void testIsEmpty() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        assertEquals(true, arrayList.isEmpty());

        arrayList = new ImmutableArrayList(new Object[]{1, 2, 3});
        assertEquals(false, arrayList.isEmpty());
    }

    @Test
    public void testToArray() {
        Object[] exp = new Object[]{"1", "2", "3", "4", "5"};
        ImmutableArrayList arrayList = new ImmutableArrayList();
        int[] Data = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < 5; i++) {
            arrayList = arrayList.add(Data[i]);
        }
        Object[] elements = arrayList.toArray();
        for (int i = 0; i < elements.length; i++) {
            assertEquals(exp[i], elements[i].toString());
        }
    }

}