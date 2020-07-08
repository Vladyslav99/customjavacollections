package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {

    private Node first;
    private Node last;

    private int size;

    @SuppressWarnings("all")
    @Override
    public void clear() {
        for (Node node = first; node != null; ) {
            Node next = node.next;
            node.prev = null;
            node.next = null;
            node.element = null;
            node = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private static class Node {
        Object element;
        Node next;
        Node prev;

        public Node(Node prev, Object element, Node next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    private class IteratorImpl implements Iterator<Object> {

        Node cursor;

        public IteratorImpl() {
            cursor = first;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Object next() {
            if (cursor == null) {
                throw new NoSuchElementException();
            }

            Node temp = cursor;
            cursor = temp.next;
            return temp.element;
        }

    }

    @Override
    public void addFirst(Object element) {
        final Node f = first;
        final Node newNode = new Node(null, element, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    @Override
    public void addLast(Object element) {
        final Node l = last;
        final Node newNode = new Node(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public void removeFirst() {
        final Node f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        unlinkFirst(f);
    }

    @Override
    public void removeLast() {
        final Node l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        unlinkLast(l);
    }

    @SuppressWarnings("all")
    @Override
    public Object getFirst() {
        return first.element;
    }

    @SuppressWarnings("all")
    @Override
    public Object getLast() {
        return last.element;
    }

    @Override
    public Object search(Object element) {
        Iterator<Object> iterator = iterator();
        while (iterator.hasNext()) {
            Object currentElement = iterator.next();
            if (currentElement.equals(element)) {
                return currentElement;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        Iterator<Object> iterator = iterator();
        Node currentNode = first;
        while (iterator.hasNext()) {
            Object currentElement = iterator.next();
            if (currentElement.equals(element)) {
                unlink(currentNode);
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    private void unlink(Node node) {
        final Node prev = node.prev;
        final Node next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        Iterator<Object> iterator = iterator();

        while (iterator.hasNext()) {
            stringBuilder.append(", " + iterator.next().toString());
        }

        return stringBuilder.toString().replaceFirst(",", "").trim();
    }

    private void unlinkLast(Node l) {
        final Node prev = l.prev;
        l.element = null;
        l.prev = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;
    }

    private void unlinkFirst(Node f) {
        final Node next = f.next;
        f.element = null;
        f.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
    }

    public static void main(String[] args) {
        List list = new ListImpl();

        for (int i = 0; i < 10; i++) {
            list.addFirst(i + 1);
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        list.clear();

        for (int i = 0; i < 10; i++) {
            list.addLast(i + 1);
        }

        iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }


    }
}
