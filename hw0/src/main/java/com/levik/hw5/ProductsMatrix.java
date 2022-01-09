package com.levik.hw5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ProductsMatrix {

    private static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputs = input.nextLine();

        String[] item = inputs.split(SPACE);
        int n = Integer.parseInt(item[0]);
        long k = Long.parseLong(item[1]);

        long position = solution(n, k);
        System.out.println(position);
    }

    public static long solution(int n, long k) {
        PriorityQueue<Long> minHeap = createMinHeap(n);

        long i = 1;
        long item = -1;

        while (i <= k) {
            item = minHeap.poll();
            i++;
        }

        return item;
    }

    private static PriorityQueue<Long> createMinHeap(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long iteration = 1;

        for(int i = 0; i < n; i++) {
            int item = 1;

            for (int j = 0; j < n; j++) {
                minHeap.add(item * iteration);
                item++;
            }

            iteration++;
        }

        return minHeap;
    }

}
