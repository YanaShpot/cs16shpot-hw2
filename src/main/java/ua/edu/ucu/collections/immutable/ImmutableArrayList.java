package ua.edu.ucu.collections.immutable;

import java.util.InputMismatchException;

public class ImmutableArrayList implements ImmutableList{

    private final int size;
    private final Object[] value;

    public ImmutableArrayList() {
        this.size = 0;
        this.value = null;
    }
 
    public ImmutableArrayList(Object[] value) {
        this.value = value;
        this.size = this.value.length;
    }

    public Object[] getValue() {
        return this.value;
    }



    @Override
    public ImmutableArrayList add(Object e) {
        Object[] newList = new Object[this.size + 1];
        for (int i = 0; i < this.size; i++) {
            newList[i] = this.value[i];
        }

        newList[this.size] = e;
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newList = new Object[this.size + 1];
        for (int i = 0; i < index; i++) {
            newList[i] = this.value[i];
        }

        newList[index] = e;
        for (int i = index; i < this.size; i++) {
            newList[i + 1] = this.value[i];
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        Object[] newList = new Object[this.size + c.length];
        for (int i = 0; i < this.size; i++) {
            newList[i] = this.value[i];
        }

        for (int i = 0; i < c.length; i++) {
            newList[this.size + i] = c[i];
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newList = new Object[this.size + c.length];
        for (int i = 0; i < index; i++) {
            newList[i] = this.value[i];
        }

        for (int i = 0; i < c.length; i++) {
            newList[index + i] = c[i];
        }

        for (int i = 0; i < this.size - index; i++) {
            newList[c.length + i] = this.value[index + i];
        }

        return new ImmutableArrayList(newList);
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        if (index < this.size && index >= 0) {
            return this.value[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ImmutableArrayList remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newList = new Object[this.size - 1];
        for (int i = 0; i < index; i++) {
            newList[i] = this.value[i];
        }

        for (int i = index; i < this.size-1; i++ ) {
            newList[i] = this.value[i + 1];
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) throws IndexOutOfBoundsException {
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newList = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                newList[index] = e;
            }
            else {
                newList[i] = this.value[i];
            }
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size; i++) {
            if (this.value[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newList = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            newList[i] = this.value[i];
        }
        return newList;
    }

    @Override
    public String toString() {
        String toStr = "Immutable ArrayList:\n";
        for (int i = 0; i<this.size; i++) {
            toStr += this.value[i] + ", ";
        }
        return toStr;
    }
}