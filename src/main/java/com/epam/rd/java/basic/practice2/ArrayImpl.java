package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {

    private Object[] elementData;

    private int size;

    /**
     *
     * public ArrayImpl(int initialCapacity) {
     *         if (initialCapacity >= 0) {
     *             elementData = new Object[initialCapacity];
     *         } else {
     *             throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
     *         }
     *     }
     *
     *     public ArrayImpl() {
     *         elementData = new Object[0];
     *     }
     */



    @Override
    public void clear() {

        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }

        size = 0;
    }

    @Override
    public int size() {
        return elementData.length;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != elementData.length;
        }

        @Override
        public Object next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }

            return elementData[cursor++];
        }

    }

    @Override
    public void add(Object element) {
        if (size == elementData.length) {
            extendStorage();
        }

        elementData[size++] = element;
    }

    private void extendStorage() {
        Object[] tempData = elementData;
        elementData = new Object[tempData.length + 1];
        System.arraycopy(tempData, 0, elementData, 0, tempData.length);
    }

    @Override
    public void set(int index, Object element) {
        rangeCheck(index);
        elementData[index] = element;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    @Override
    public int indexOf(Object element) {

        for (int i = 0; i < elementData.length; i++){
            if (element.equals(elementData[i])){
                return i;
            }
        }

        return -1;
    }

    @Override
    public void remove(int index) {
        rangeCheck(index);
        elementData[index] = null;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > elementData.length - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Object> iterator = iterator();

        while (iterator.hasNext()){
            stringBuilder.append(" " + iterator.next().toString());
        }

        return stringBuilder.toString().trim();
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {


    }

}
