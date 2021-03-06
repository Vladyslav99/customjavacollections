package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {

    private Node first;
    private Node last;

    private int size;

    @Override
    public void clear() {

        Node node = first;

        while (node != null){
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

        @Override
        public void remove() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            next();
            ListImpl.this.removeFirst();
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
            return;
        }
        unlinkFirst(f);
    }

    @Override
    public void removeLast() {
        final Node l = last;
        if (l == null) {
            return;
        }
        unlinkLast(l);
    }

    @Override
    public Object getFirst() {
        if (first == null) {
            return null;
        }
        return first.element;
    }

    @Override
    public Object getLast() {
        if (first == null) {
            return null;
        }
        return last.element;
    }

    @Override
    public Object search(Object element) {

        Iterator<Object> iterator = iterator();

        if (element == null) {
            while (iterator.hasNext()) {
                if (iterator.next() == null) {
                    return null;
                }
            }
        } else {
            while (iterator.hasNext()) {
                Object currentElement = iterator.next();
                if (element.equals(currentElement)) {
                    return currentElement;
                }
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        Iterator<Object> iterator = iterator();
        Node currentNode = first;

        if (element == null) {
            while (iterator.hasNext()) {
                if (iterator.next() == null) {
                    unlink(currentNode);
                    return true;
                }
                currentNode = currentNode.next;
            }
        } else {
            while (iterator.hasNext()) {
                Object currentObject = iterator.next();
                if (element.equals(currentObject)) {
                    unlink(currentNode);
                    return true;
                }
                currentNode = currentNode.next;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        Iterator<Object> iterator = iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next()).append(",").append(" ");
        }

        if (stringBuilder.length() > 2) {
            return stringBuilder.deleteCharAt(stringBuilder.length() - 2)
                    .insert(stringBuilder.length() - 1, "]")
                    .toString()
                    .trim();
        }

        return stringBuilder.append("]").toString();
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
        size--;
    }

    public static void main(String[] args) {
        //ListImpl main
    }
}
