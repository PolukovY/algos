package com.levik.hw3;

import java.util.Scanner;

public class TaskB {

    public static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] inputs = input.nextLine().split(SPACE);

        int n = Integer.parseInt(inputs[0]);
        int p = Integer.parseInt(inputs[1]);

        String[] items = input.nextLine().split(SPACE);
        int[] a = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            a[i] = Integer.parseInt(items[i]);
        }

        Tuple solution = solution(a, p);
        System.out.println(solution.first + SPACE + solution.second);
    }

    public static Tuple solution(int[] array, int target) {
        int n = array.length;
        int m = n - 1;
        int end = 0;

        int maxStart = 0;
        int maxCount = Integer.MAX_VALUE;

        int currentCount = 0;
        int currentSum = 0;

        for (int start = 0; start < n; start++) {
            currentSum += array[start];

            while (end < m && currentSum < target) {
                currentSum += array[++end];
                currentCount++;

                if (currentSum >= target && currentCount < maxCount) {
                    maxCount = currentCount;
                    maxStart = start;

                    end = start + 1;
                }
            }

            currentCount = 0;
            currentSum = 0;
        }

        return new Tuple(maxStart + 1, maxCount + 1);
    }

    static class Tuple {
        public final int first;
        public final int second;

        Tuple(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
