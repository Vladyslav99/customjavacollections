package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class QueueImpl implements Queue {

    private ListImpl queue;

    public QueueImpl() {
        queue = new ListImpl();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public int size() {
        return queue.size();
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        @Override
        public boolean hasNext() {
            return queue.iterator().hasNext();
        }

        @Override
        public Object next() {
            return queue.iterator().next();
        }

    }

    @Override
    public void enqueue(Object element) {
        queue.addLast(element);
    }

    @Override
    public Object dequeue() {
        Object object = queue.getFirst();
        queue.removeFirst();
        return object;
    }

    @Override
    public Object top() {
        return queue.getFirst();
    }

    @Override
    public String toString() {
        return queue.toString();
    }


    public static void main(String[] args) {

        Queue queue = new QueueImpl();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i + 1);
        }

        System.out.println(queue.toString());

    }

}
