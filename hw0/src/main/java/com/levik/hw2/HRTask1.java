package com.levik.hw2;

import java.util.*;

public class HRTask1 {

    public static final String SPLITERATOR = " ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int trips = input.nextInt();

        for (int i = 0; i < trips; i++) {
            int money = input.nextInt();
            int flavorSize = input.nextInt();

            int[] flowers = new int[flavorSize];
            for(int j = 1; j <= flavorSize; j++){
                int cost = input.nextInt();
                flowers[j - 1] = cost;
            }

            int[] solution = solution5(flowers, money);
            System.out.println(solution[0] + SPLITERATOR + solution[1]);
        }
    }

    public static int[] solution5(int[] flowers, int money) {
        int[] clonedItems = flowers.clone();
        int[] sortedItems = sort(clonedItems);

        return new int[0];
    }

    private static int[] sort(int[] items) {
        Map<Integer, Integer> counting = new HashMap<>();
        for (int item : items) {
            int count = counting.getOrDefault(item, 0);
            counting.put(item, ++count);
        }

        int[] sortedItems = new int[items.length];
        int index = 0;

        for (int key : counting.keySet()) {
            int value = counting.get(key);
            for (int i = 0; i< value; i++) {
                sortedItems[index++] = key;
            }
        }

        return sortedItems;
    }

    public static int[] solution4(int[] flowers, int money) {
        int[] sortedItems = flowers.clone();
        Arrays.sort(sortedItems);

        int i = 0;
        int j = flowers.length - 1;

        while (i <= j) {
            int currentSum = sortedItems[i] + sortedItems[j];

            if (currentSum == money) {
                int originalFirstIndex = getOriginalIndex(flowers, sortedItems[i], -1);
                int originalSecondIndex = getOriginalIndex(flowers, sortedItems[j], originalFirstIndex);
                int[] ints = sortItems(originalFirstIndex, originalSecondIndex);
                return sortItems(ints[0] + 1, ints[1] + 1);
            } else if (currentSum > money) {
                j--;
            } else {
                i++;
            }
        }

        return new int[] {-1, -1};
    }

    private static int getOriginalIndex(int[] costs, int value, int excludeIndex) {
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] == value && excludeIndex != i) {
                return i;
            }
        }

        return -1;
    }

    public static int[] sortItems(int a, int b) {
        return a > b ? new int[]{b, a}: new int[]{a, b};
    }

    public static int[] solution3(int[] flowers, int money) {
        for (int i = 0; i < flowers.length; i++) {
            int firstValue = flowers[i];
            for (int j = i + 1; j < flowers.length; j++) {
                int secondValue = flowers[j];
                if (firstValue + secondValue == money) {
                    return sortItems(i + 1, j + 1);
                }
            }
        }

        return new int[0];
    }


    public static int[] solution2(int[] flowers, int money) {
        Map<Integer, Integer> tmp = new HashMap<>();
        for (int i = 0; i < flowers.length; i++) {
            int cost = flowers[i];
            if(tmp.containsKey(cost)){
                return new int[]{tmp.get(cost), i + 1};
            } else {
                tmp.put(money - cost, i + 1);
            }
        }

        return new int[0];
    }

    public static int[] solution(int[] flowers, int money) {
        int[] items = flowers.clone();
        Arrays.sort(items);

        for (int i = 0; i < items.length; i++) {
            int costItem = items[i];
            int balance = money - costItem;

            int index = Arrays.binarySearch(items, i + 1, items.length, balance);
            if (index >= 0 && index <= items.length - 1 && items[index] + costItem == money) {
                int[] values = sortItems(items[index], costItem);

                int originalFirstIndex = getOriginalIndex(flowers, values[0], -1);
                int originalSecondIndex = getOriginalIndex(flowers, values[1], originalFirstIndex);

                return new int[] {originalFirstIndex + 1, originalSecondIndex + 1};
            }
        }

        return new int[0];
    }
}
