package com.levik.hw4;

import java.util.LinkedList;

public class MyCircularDeque {

    private static final int FIRST = 0;

    private final LinkedList<Integer> dequeue;
    private final int capacity;

    public MyCircularDeque(int k) {
        this.dequeue = new LinkedList<>();
        this.capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        dequeue.add(FIRST, value);
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        return dequeue.add(value);
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        dequeue.removeFirst();
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        dequeue.removeLast();
        return true;
    }

    public int getFront() {
        if (isEmpty()){
            return -1;
        }

        return dequeue.get(FIRST);
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return dequeue.get(dequeue.size() - 1);

    }

    public boolean isEmpty() {
        return dequeue.size() == 0;
    }

    public boolean isFull() {
        return dequeue.size() == capacity;
    }
}
