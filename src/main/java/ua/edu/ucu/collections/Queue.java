package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList linkedList;

    public Queue(){
        linkedList = new ImmutableLinkedList();
    }

    public void enqueue(Object o){
        linkedList = linkedList.add(o);

    }

    public Object peek(){
        return linkedList.getFirst();

    }

    public Object dequeue(){
        Object o = linkedList.getFirst();
        linkedList = linkedList.removeFirst();
        return o;

    }

}