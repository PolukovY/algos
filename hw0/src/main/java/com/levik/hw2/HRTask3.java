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

        long[] solution = solution(k);
        System.out.println(convert(solution));
    }

    private static String convert(long[] items) {
        StringJoiner result = new StringJoiner(SPLITERATOR);
        for (long item : items) {
            result.add(String.valueOf(item));
        }
        return result.toString();
    }

    public static long[] solution(int[] k) {
        long[] res = new long[k.length];

        for (int i = 0; i < k.length; i++) {
            res[i] = calc(k[i] - 1);
        }

        return res;
    }

    /**
     * N = 1 + (1 + 2 + ... x) = 1 + x(x + 1) / 2
     **/
    private static long calc(int i) {
        double n = (Math.sqrt(8.0 * i + 1) -1) / 2;
        return n == (int)n ? 1 : 0;
    }
}
