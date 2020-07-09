package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {

    private int top;
    private Object[] elementData;
    private static final int INITIAL_CAPACITY = 16;

    public StackImpl() {
        elementData = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void clear() {
        elementData = new Object[INITIAL_CAPACITY];
        top = 0;
    }

    @Override
    public int size() {
        return top;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        int cursor;

        public IteratorImpl() {
            cursor = top;
        }

        @Override
        public boolean hasNext() {
            return cursor != 0;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elementData[--cursor];
        }

    }

    @Override
    public void push(Object element) {
        if (top == elementData.length) {
            expandSize();
        }
        elementData[top++] = element;
    }

    private void expandSize() {
        int newSize = (int) (elementData.length * 1.5);
        Object[] tempElements = elementData;
        elementData = new Object[newSize];
        System.arraycopy(tempElements, 0, elementData, 0, tempElements.length);
    }

    @Override
    public Object pop() {
        if (top == 0) {
            return null;
        }
        Object object = elementData[--top];
        elementData[top] = null;
        return object;
    }

    @Override
    public Object top() {
        if (top == 0) {
            return null;
        }
        return elementData[top - 1];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < top; i++) {
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
