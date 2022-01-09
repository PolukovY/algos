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
        int k = Integer.parseInt(item[1]);

        int position = solution(n, k);
        System.out.println(position);
    }

    public static int solution(int n, int k) {
        PriorityQueue<Integer> minHeap = createMinHeap(n);

        int i = 1;
        int item = -1;

        while (i <= k) {
            item = minHeap.poll();
            i++;
        }

        return item;
    }

    private static PriorityQueue<Integer> createMinHeap(int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int iteration = 1;

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
