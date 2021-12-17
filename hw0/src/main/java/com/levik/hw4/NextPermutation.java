package com.levik.hw4;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return ;
        }

        int i = nums.length - 2;
        int n = nums.length - 1;

        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if(i >= 0) {
            int j = n;
            while(nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        reverse(nums, i + 1, n);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i++, j--);
        }
    }
}
