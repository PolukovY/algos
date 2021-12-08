package com.levik.hw3;

public class HeapArray {

    private final int[] items;

    public HeapArray(int[] items) {
        this.items = items;
    }

    public int parent(int i) {
        return i / 2;
    }

    public int left(int i) {
        return i * 2;
    }

    public int right(int i) {
        return i * 2 + 1;
    }
}
