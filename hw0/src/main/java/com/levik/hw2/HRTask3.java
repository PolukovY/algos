package com.levik.hw2;

import java.util.*;

public class HRTask3 {
    public static final String SPLITERATOR = " ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] k = new int[n];
        for (int i = 0; i< n; i++) {
            k[i] = input.nextInt();
        }

        int[] solution = solution(k);
        System.out.println(convert(solution));
    }

    private static String convert(int[] items) {
        StringJoiner result = new StringJoiner(SPLITERATOR);
        for (int item : items) {
            result.add(String.valueOf(item));
        }
        return result.toString();
    }

    public static int[] solution(int[] k) {
        int[] res = new int[k.length];

        for (int i = 0; i < k.length; i++) {
            res[i] = calc(k[i]);
        }

        return res;
    }

    private static int calc(int i) {
        long n = (long) (Math.sqrt(0.25 + 2 * i) - 0.5);
        long diff = i - (long) (n * (n + 1) / 2.0);
        return diff == 1 || i == 1 ? 1 : 0;
    }
}
