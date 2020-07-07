package com.epam.rd.java.basic.practice2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] objectData;

    private int size;

    public ArrayImpl() {
        objectData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayImpl(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        objectData = new Object[initialCapacity];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            objectData[i] = null;
        }

        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            if (cursor == size) {
                throw new NoSuchElementException();
            }

            return objectData[cursor++];
        }

    }

    @Override
    public void add(Object element) {
        if (size == objectData.length) {
            throw new IndexOutOfBoundsException();
        }
        objectData[size++] = element;
    }

    @Override
    public void set(int index, Object element) {
        if (index < 0 || index > objectData.length - 1) {
            throw new IllegalArgumentException("Illegal Index: " + index);
        }

        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        objectData[index] = element;

    }

    @Override
    public Object get(int index) {

        if (index < 0 || index > objectData.length - 1) {
            throw new IllegalArgumentException("Illegal Index: " + index);
        }

        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        return objectData[index];
    }

    @Override
    public int indexOf(Object element) {

        for (int i = 0; i < size; i++) {
            if (element.equals(objectData[i])) {
                return i;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > objectData.length - 1) {
            throw new IllegalArgumentException("Illegal Index: " + index);
        }

        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        objectData[index] = null;
        System.arraycopy(objectData, index + 1, objectData, index, --size - index);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        Iterator<Object> iterator = iterator();

        while (iterator.hasNext()) {
            stringBuilder.append(" " + iterator.next().toString());
        }

        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {

        ArrayImpl array = new ArrayImpl();


        for (int i = 0; i < 7; i++) {
            array.add(i);
        }

        System.out.println(array.toString());

        array.set(2, 100);

        System.out.println(array.toString());

    }

}
