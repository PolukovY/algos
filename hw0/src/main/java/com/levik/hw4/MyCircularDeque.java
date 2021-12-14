package com.levik.hw4;

import java.util.Arrays;

public class MyCircularDeque {

    private static final int NULL = -1;
    private static final int ZERO = 0;

    private final int[] dequeue;
    private int size;
    private int head;
    private int tail;

    public MyCircularDeque(int k) {
        this.dequeue = new int[k];
        Arrays.fill(dequeue, NULL);
        this.size = ZERO;
    }

    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }

        if(isEmpty()) {
            head = ZERO;
            tail = ZERO;
            dequeue[tail] = value;
            size++;
            return true;
        }

        head--;
        if (head == NULL){
            head = dequeue.length - 1;
        }
        dequeue[head] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }

        if (isEmpty()) {
            head = ZERO;
            tail = ZERO;
            dequeue[tail] = value;
            size++;
            return true;
        }

        tail++;
        tail = tail % dequeue.length;
        dequeue[tail] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }

        dequeue[head] = NULL;
        head++;
        head = head % dequeue.length;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }

        dequeue[tail] = NULL;
        tail--;

        if(tail == NULL) {
            tail = dequeue.length - 1;
        }

        size--;
        return true;
    }

    public int getFront() {
        return dequeue[head];
    }

    public int getRear() {
        return dequeue[tail];
    }

    public boolean isEmpty() {
        return size == ZERO;
    }

    public boolean isFull() {
        return size == dequeue.length;
    }
}
