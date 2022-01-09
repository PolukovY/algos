package com.levik.hw5;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    private static final int ZERO = 0;
    private static final int ONE = 1;

    public int lastStoneWeight(int[] stones) {
        if (stones.length == ONE) {
            return stones[ZERO];
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //(a, b) -> b - a
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > ONE) {
            int firstStone = maxHeap.poll();
            int secondStone = maxHeap.poll();

            if (firstStone != secondStone) {
                int newStone = firstStone - secondStone;
                maxHeap.add(newStone);
            }
        }

        return maxHeap.isEmpty() ? ZERO : maxHeap.poll();
    }
}
