package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private int size = 0;
    private int modCount = 0;
    private Node<T> head;

    public void add(T value) {
        if (size == 0) {
            head = new Node<>(value, null);
        } else {
            Node<T> lastNode = head;
            for (int i = 0; i < size - 1; i++) {
                lastNode = lastNode.next;
            }
            lastNode.next = new Node<>(value, null);
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    public T deleteFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T rsl = head.item;
        Node<T> newHead = head.next;
        head.next = null;
        head.item = null;
        head = newHead;
        modCount++;
        size--;
        return rsl;
    }

    public void addFirst(T value) {
        head = new Node<>(value, head);
        modCount++;
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> nextNode = head;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return nextNode != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T rsl = nextNode.item;
                nextNode = nextNode.next;
                return rsl;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}
