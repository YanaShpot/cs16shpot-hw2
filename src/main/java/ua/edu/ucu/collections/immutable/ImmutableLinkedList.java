package ua.edu.ucu.collections.immutable;
import jdk.nashorn.internal.ir.annotations.Immutable;
import java.util.LinkedList;

import java.util.NoSuchElementException;

public class ImmutableLinkedList implements ImmutableList  {

    private final int size;
    private final Node head;
    private final Node tail;

    public ImmutableLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }


    public ImmutableLinkedList(Node head) {
        this.head = head;
        int countSize = 0;
        if (head != null) {
            countSize = 1;
            Node currNode = head;
            while (currNode.getNext() != null) {
                currNode = currNode.getNext();
                countSize += 1;
            }
            this.tail = currNode;
        }
        else {
            this.tail = null;
        }
        this.size = countSize;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        if (isEmpty()) {
            Node newHead = new Node(e,null);
            return  new ImmutableLinkedList(newHead);
        }

        return add(this.size,e);

    } //додає елемент у кінець колекції

    @Override
    public ImmutableLinkedList add(int index, Object e) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node newHead = nodechainCopy();
        if (index == 0) {
            return new ImmutableLinkedList(new Node(e,newHead));
        }
        Node currNode = newHead;

        for (int i = 0; i < index - 1; ++i) {
            currNode = currNode.getNext();
        }
        currNode.setNext(new Node(e,currNode.getNext()));
        return new ImmutableLinkedList(newHead);



    }; //додає елемент до колекції за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    @Override
    public ImmutableLinkedList addAll(Object[] c) throws NullPointerException {
        if(c == null) {
            throw new NullPointerException();
        }
        return addAll(size(),c);
        
    }; //додає масив елементів у кінець колекції

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) throws NullPointerException {
        if (c == null) {
            throw new NullPointerException();
        }
        ImmutableLinkedList newList = new ImmutableLinkedList(nodechainCopy());
        for (Object o : c) {
            newList = newList.add(index,o);
            ++index;
        }
        return newList;

    }; // додає масив елементів починаючи з зазначеного індекса, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
            if (index < 0 || index >= size()) {
                throw new IndexOutOfBoundsException();
            }
        Node currNode = this.head;
        for (int i = 0; i < index; ++i) {
            currNode = currNode.getNext();
        }
        return currNode.getValue();
        }; //повертає елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    @Override
    public ImmutableLinkedList remove(int index) throws IndexOutOfBoundsException {
        if (isEmpty()||index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node newHead = nodechainCopy();
        if (index == 0) {
            return new ImmutableLinkedList(newHead.getNext());
        }
        Node currNode = newHead;
        for (int i=0; i< index - 1; ++i) {
            currNode = currNode.getNext();
        }
        currNode.setNext(currNode.getNext().getNext());
        return new ImmutableLinkedList(newHead);

    }; //видаляє елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    @Override
    public ImmutableLinkedList set(int index, Object e) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node newHead = nodechainCopy();
        Node currNode = newHead;
        for(int i = 0; i<index; ++i) {
            currNode = currNode.getNext();
        }
        currNode.setValue(e);
        return new ImmutableLinkedList(newHead);

    }; //змінює значення елементу за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    @Override
    public int indexOf(Object e) {
        Node currNode = this.head;
        if (currNode.getValue().equals(e))
            return 0;
        for (int i = 1; i < size; i++) {
            currNode = currNode.getNext();
            if (currNode.getValue().equals(e))
                return i;
        }
        return -1;
}; //шукає індекс елемента (повертає індекс першого який знайшов, або -1 у випадку відсутності)

    @Override
    public int size() {
        return this.size;
    }; //розмір колекції

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }; //очищує вміст колекції

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }; //якщо у колеції нема елементів то повертає true

    @Override
    public Object[] toArray()  {
        /*if (isEmpty()) {
            throw new NullPointerException();
        }*/
        Object[] newArr = new Object[this.size];
        Node currNode = this.head;
        newArr[0] = currNode.getValue();
        for (int i = 1; i < size; i++) {
            currNode = currNode.getNext();
            newArr[i] = currNode.getValue();
        }
        return newArr;


        
    }; //перетворює колекцію до масив обєктів

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        String toStr = "ImmutableLinkedList:\n";
        Object[] listToArr = toArray();
        for (int i = 0; i<listToArr.length - 1;++i) {
            toStr += listToArr[i] + ", ";
        }
        toStr += listToArr[listToArr.length - 1];
        return toStr;
    /*for (Object o : listToArr) {
        toStr += o;
        while (o != listToArr[this.size - 1]) {
            toStr += ", ";
        }

    }
    return toStr;*/

}; //повертає рядок, де через кому відображаютсься елементи колекції

    public ImmutableLinkedList addFirst(Object e) {

        return add(0,e);
    }


    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst() throws NoSuchElementException {
        if (!isEmpty()) {
            return this.head.getValue();
        }
        throw new NoSuchElementException();

    }

    public Object getLast() throws NoSuchElementException {
        if (!isEmpty()) {
            return this.tail.getValue();
        }
        throw new NoSuchElementException();

    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);

    }

    public ImmutableLinkedList removeLast() {
        return remove(this.size - 1);
    }


    private Node nodechainCopy() {
        if (isEmpty()) {
            return null;
        }
        Node currNode = this.head;
        Node newHead = new Node(this.head.getValue(), null);
        Node lookOverNodeNew = newHead;
        while (currNode != this.tail) {
            currNode = currNode.getNext();
            lookOverNodeNew.setNext(new Node(currNode.getValue(), null));
            lookOverNodeNew = lookOverNodeNew.getNext();
        }
        return newHead;
    }

}
