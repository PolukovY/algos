package com.levik.hw3;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                res[left] = num;
                left++;
            } else {
                res[right] = num;
                right--;
            }
        }

        return res;
    }
}
