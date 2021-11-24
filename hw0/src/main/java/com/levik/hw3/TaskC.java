package com.levik.hw3;

import java.util.*;

public class TaskC {

    public static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] inputs = input.nextLine().split(SPACE);

        int n = Integer.parseInt(inputs[0]);
        int s = Integer.parseInt(inputs[1]);

        String[] items = input.nextLine().split(SPACE);
        int[] a = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            a[i] = Integer.parseInt(items[i]);
        }

        int solution = solution(a, s);
        System.out.println(solution);
    }

    public static int solution(int[] array, int target) {
        int left = 0;
        int sum = 0;
        int count  = 0;
        Set<List<Integer>> subArrays = new HashSet<>();
        System.out.println(Arrays.toString(array) + " target: " + target + "\n");

        for (int right = 0; right < array.length; right++) {
            int rightValue = array[right];
            sum += rightValue;

            while (sum > target) {
                int leftValue = array[left];
                sum -= leftValue;
                left++;
            }

            findCombinations(array, left, right, target, subArrays);
            System.out.println("Sum: " + sum + " subArraysSum: " + sum(subArrays) + " left: " + left + " right: " + right);
            System.out.println();

            //count += right - left + 1;
        }

        return sum(subArrays);
    }

    private static int sum(Set<List<Integer>> subArrays) {
        int sum = 0;
        for (List<Integer> subArray : subArrays) {
            sum += subArray.size();
            System.out.println(Arrays.toString(subArray.toArray()) + " -> " + subArray.size());
        }

        return sum;
    }

    public static void findCombinations(int[] array, int start, int end, int k,
                                        Set<List<Integer>> subArrays,
                                        List<Integer> combinations) {
        if (k == 0) {
            subArrays.add(new ArrayList<>(combinations));
            return;
        }

        for (int j = start; j <= end; j++) {
            combinations.add(array[j]);
            findCombinations(array, j + 1, end, k - 1, subArrays, combinations);
            combinations.remove(combinations.size() - 1);
        }
    }

    public static void findCombinations(int[] array, int start, int end, int k, Set<List<Integer>> subArrays) {
        for (int i = 1; i <= k; i++) {
            findCombinations(array, start, end, i, subArrays, new ArrayList<>());
        }
    }

}
