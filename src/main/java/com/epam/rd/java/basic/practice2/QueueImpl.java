package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {

    private static final int INITIAL_CAPACITY = 10;

    private int total;
    private int first;
    private int next;
    private Object[] elementData;

    public QueueImpl() {
        elementData = new Object[INITIAL_CAPACITY];
    }


    @Override
    public void clear() {
        elementData = new Object[INITIAL_CAPACITY];
        total = first = next = 0;
    }

    @Override
    public int size() {
        return total;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != total;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return elementData[(first + cursor++) % elementData.length];
        }

    }

    @Override
    public void enqueue(Object element) {
        if (elementData.length == total) {
            resize(elementData.length * 2);
        }
        elementData[next++] = element;
        if (next == elementData.length) {
            next = 0;
        }
        total++;
    }

    private void resize(int capacity) {
        Object[] tempElements = new Object[capacity];

        for (int i = 0; i < total; i++) {
            tempElements[i] = elementData[(first + i) % elementData.length];
        }

        elementData = tempElements;
        first = 0;
        next = total;
    }

    @Override
    public Object dequeue() {

        if (total == 0) {
            return null;
        }
        Object element = elementData[first];
        elementData[first] = null;

        if (++first == elementData.length) {
            first = 0;
        }

        if (--total > 0 && total == elementData.length / 4) {
            resize(elementData.length / 2);
        }

        return element;
    }

    @Override
    public Object top() {
        return elementData[first];
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < total; i++) {
            stringBuilder.append(elementData[(first + i) % elementData.length] + ", ");
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
