package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {

    private static final int DEFAULT_CAPACITY = 16;

    private Object[] elementData;

    private int size;

    public ArrayImpl(int initialCapacity) {
        if (initialCapacity >= 0) {
            elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public ArrayImpl() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
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
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return elementData[cursor++];
        }

    }

    @Override
    public void add(Object element) {
        if (size == elementData.length) {
            resizeCapacity(size * 2);
        }

        elementData[size++] = element;
    }

    private void resizeCapacity(int newCapacity) {
        Object[] tempElements = elementData;
        elementData = new Object[newCapacity];
        System.arraycopy(tempElements, 0, elementData, 0, size);
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
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elementData[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public void remove(int index) {
        rangeCheck(index);
        System.arraycopy(elementData, index + 1, elementData, index, size - 1 - index);
        if (--size > 0 && size == elementData.length / 4) {
            resizeCapacity(elementData.length / 2);
        }
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(elementData[i] + ", ");
        }

        if (stringBuilder.length() > 2) {
            return stringBuilder.deleteCharAt(stringBuilder.length() - 2)
                    .insert(stringBuilder.length() - 1, "]")
                    .toString()
                    .trim();
        }


        return stringBuilder.append("]").toString();
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {

    }

}









