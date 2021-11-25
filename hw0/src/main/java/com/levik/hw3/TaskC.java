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

        for (int right = 0; right < array.length; right++) {
            sum += array[right];

            while (sum > target) {
                sum -= array[left];
                left++;
            }

            count += sum(right - left + 1);
        }

        return count;
    }

    private static int sum(int n) {
        int sum = 0;

        for (int i = 1; i <= n;i++) {
            sum+=i;
        }
        return sum;
    }

}
