package com.levik.hw4;

import java.util.Deque;
import java.util.LinkedList;

public class RecentCounter {

    private final Deque<Integer> deque;

    public RecentCounter() {
        this.deque = new LinkedList<>();

    }

    public int ping(int t) {
        deque.add(t);
        while (deque.getFirst() <  t - 3000) {
            deque.pollFirst();
        }

        return deque.size();
    }
}
