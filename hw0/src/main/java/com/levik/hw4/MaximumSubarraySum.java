package com.levik.hw4;

public class MaximumSubarraySum {

    private static final int CHAR_BIT = 4;
    private static final int INT_BIT = 8;

    //O(n) - time, O(1)- space (without branching using bits or use Math.max)
    public static int maximumSum(int[] arr) {
        int currentSum = 0;
        int sumWithDeleted = arr[0];
        int maximumSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i];
            int newPotentialSum = currentSum + currentValue;
            currentSum = max(sumWithDeleted, newPotentialSum);

            int newPotentialSumWithDeleted = sumWithDeleted + currentValue;
            sumWithDeleted = max(newPotentialSumWithDeleted, currentValue);

            maximumSum = max(maximumSum, Math.max(currentSum, sumWithDeleted));
        }

        return maximumSum;
    }

    private static int max(int x, int y) {
        return x - ((x - y) & ((x - y) >> (INT_BIT * CHAR_BIT - 1)));
    }
}
