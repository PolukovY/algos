package com.levik.hw3;

public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        return sort(nums);
    }

    private int[] sort(int[] nums) {
        int[] res = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;

        for (int index = nums.length - 1; index >= 0; index--) {
            int num;
            int leftValue = Math.abs(nums[left]);
            int rightValue = Math.abs(nums[right]);

            if(leftValue > rightValue){
                num = leftValue;
                left++;
            } else {
                num = rightValue;
                right--;
            }

            res[index] = num * num;
        }

        return res;
    }
}
