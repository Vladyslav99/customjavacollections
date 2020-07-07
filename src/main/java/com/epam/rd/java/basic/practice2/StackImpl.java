package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class StackImpl implements Stack {

    private ListImpl stack;

    public StackImpl(){
        stack = new ListImpl();
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public int size() {
        return stack.size();
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

//        @Override
//        public boolean hasNext() {
//            return stack.iterator().hasNext();
//        }
//
//        @Override
//        public Object next() {
//            return stack.getLast();
//        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

    }

    @Override
    public void push(Object element) {
        stack.addLast(element);
    }

    @Override
    public Object pop() {
        Object object = stack.getLast();
        stack.removeLast();
        return object;
    }

    @Override
    public Object top() {
        return stack.getLast();
    }

    @Override
    public String toString() {

//        StringBuilder stringBuilder = new StringBuilder();
//
//        Iterator<Object> iterator = iterator();
//
//        while (iterator.hasNext()) {
//            stringBuilder.append(", " + stack.getLast().toString());
//        }
//
//        return stringBuilder.toString().replaceFirst(",", "").trim();

        return null;
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();

        for (int i = 0; i < 10; i++) {
            stack.push(i + 1);
        }

//        System.out.println(stack.toString());
    }

}
