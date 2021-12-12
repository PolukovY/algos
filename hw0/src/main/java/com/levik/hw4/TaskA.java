package com.levik.hw4;

import java.util.*;
import java.util.stream.Collectors;

public class TaskA {

    private static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] line = input.nextLine().split(SPACE);

        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        int[] items = getItems(input, n);

        List<Integer> results = solution(items, k);

        String text = results.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(SPACE));

        System.out.println(text);
    }

    public static List<Integer> solution(int[] items, int k) {
        int n = items.length - k + 1;
        List<Integer> minItems = new ArrayList<>();

        for (int index = 0; index < n; index++) {
            int end = index + k - 1;
            minItems.add(findMin(index, end, items));
        }

        return minItems;
    }

    private static int findMin(int start, int end, int[] item) {
        int min = item[start];

        for (int index = start + 1; index <= end; index++) {
            int value = item[index];
            min = min(min, value);

            //if (value < min) {
            //    min  = value;
            //}
        }

        return min;
    }

    public static int min(int x, int y) {
        int abs = absoluteBit32(x,y);
        return (x + y - abs) >> 1;
    }

    public static int absoluteBit32(int x, int y) {
        int sub = x - y;
        int mask = (sub >> 31);
        return (sub ^ mask) - mask;
    }

    private static int[] getItems(Scanner input, int n) {
        int[] items = new int[n];
        String[] itemsLine = input.nextLine().split(SPACE);

        for (int index = 0; index < itemsLine.length; index++) {
            items[index] = Integer.parseInt(itemsLine[index]);
        }

        return items;
    }
}
