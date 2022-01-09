package com.levik.hw5;

import java.util.Arrays;
import java.util.Scanner;

public class ProductsMatrix2 {

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
        int[] items = createMatrix(n);
        Arrays.sort(items);
        return items[k - 1];
    }

    private static int[] createMatrix(int n) {
        int[] items = new int[n * n];
        int index = 0;
        int iteration = 1;

        for(int i = 0; i < n; i++) {
            int item = 1;

            for (int j = 0; j < n; j++) {
                items[index++] = item * iteration;
                item++;
            }

            iteration++;
        }

        return items;
    }

}
