package ua.edu.ucu.collections.immutable;

/**
 * Created by Yasya on 02.01.17.
 */
public class Node {
    private Object value;
    private Node next = null;


    public Node(Object value, Node next){
        this.value = (Object)value;
        this.next = next;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }

    Object getValue() {
        return this.value;
    }

    void setValue(Object value) {
        this.value = value;
    }

    public String toString() {
        return this.value.toString();
    }
}