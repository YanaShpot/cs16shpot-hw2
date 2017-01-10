package ua.edu.ucu.collections;


import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList linkedList;

    public Stack(){
        linkedList = new ImmutableLinkedList();
    }

    public void push(Object o){
        linkedList = linkedList.add(o);

    }

    public Object pop(){
        Object o = linkedList.getLast();
        linkedList = linkedList.removeLast();
        return o;

    }

    public Object peek(){
        return linkedList.getLast();

    }
}

    

