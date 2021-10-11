package com.levik.hw1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Task3 {

    private static final String EMPTY = "";

    //O(n^2) - time, O(1) - space
    public int calcRepeatCharSlow(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            throw new IllegalArgumentException("Text should not be null");
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int targetCount = nums.length / 2;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;

                    if (count >= targetCount) {
                        return nums[i];
                    }
                }
            }
        }

        throw new RepeatedChatNotFoundException(nums);
    }

    //O(n) - time, O(n) - space
    public int calcRepeatCharFast(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            throw new IllegalArgumentException("Text should not be null");
        }

        Map<Integer, Integer> container = new HashMap<>();
        int targetCount = nums.length / 2;

        for (int num : nums) {
            int currentSumCount = sumCountForChar(container, num);

            if (currentSumCount > targetCount) {
                return num;
            }
        }

        throw new RepeatedChatNotFoundException(nums);
    }


    private int sumCountForChar(Map<Integer, Integer> container, int aChar) {
        int currentCount = container.getOrDefault(aChar, 0);
        container.put(aChar, ++currentCount);
        return currentCount;
    }

    public static class RepeatedChatNotFoundException extends RuntimeException {
        private final int[] nums;

        public RepeatedChatNotFoundException(int[] nums) {
            this.nums = nums;
        }

        public int[] getNums() {
            return nums;
        }
    }
}
