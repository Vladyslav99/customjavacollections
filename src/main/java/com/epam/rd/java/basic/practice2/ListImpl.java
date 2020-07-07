package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ListImpl implements List {

    private Node first;
    private Node last;

    private int size;

    public ListImpl(){
        first = last = null;
    }

    @Override
    public void clear() {
        
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private static class Node{
        Object element;
        Node next;

        public Node(Object element, Node next){
           this.element = element;
           this.next = next;
        }
    }

    private class IteratorImpl implements Iterator<Object> {

        Node cursor;

        public IteratorImpl(){
            cursor = new Node(null, first);
        }

        @Override
        public boolean hasNext() {
            return cursor.next != null;
        }

        @Override
        public Object next() {
            if (cursor.next == null){
                throw new NoSuchElementException();
            }

            Node temp = cursor;
            cursor = temp.next;
            return temp.element;
        }

    }

    @Override
    public void addFirst(Object element) {
        if (first == null){
            first = last = new Node(element, null);
        }else {
            Node temp = first;
            first = new Node(element, temp);
        }
        size++;
    }

    @Override
    public void addLast(Object element) {
        if (last == null){
            last = first = new Node(element, null);
        }else {
            Node temp = last;
            last = new Node(element, null);
            temp.next = last;
        }
        size++;
    }

    @Override
    public void removeFirst() {
        
    }

    @Override
    public void removeLast() {
        
    }

    @Override
    public Object getFirst() {
        return first;
    }

    @Override
    public Object getLast() {
        return last;
    }

    @Override
    public Object search(Object element) {
        return null;
    }

    @Override
    public boolean remove(Object element) {
        return false;
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

    public static void main(String[] args) {
        ListImpl list = new ListImpl();
        list.addFirst(1);

        System.out.println(list.toString());
    }
}
