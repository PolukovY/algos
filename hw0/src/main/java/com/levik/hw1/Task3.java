package com.levik.hw1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Task3 {

    private static final String EMPTY = "";

    //O(n^2) - time, O(1) - space
    public char calcRepeatCharSlow(String text) {
        if (Objects.isNull(text) || EMPTY.equals(text) || EMPTY.equals(text.trim())) {
            throw new IllegalArgumentException("Text should not be null");
        }

        char[] chars = text.toCharArray();
        int targetCount = chars.length / 2;

        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    count++;

                    if (count == targetCount) {
                        return chars[i];
                    }
                }
            }
        }

        throw new RepeatedChatNotFoundException(text);
    }

    //O(n) - time, O(n) - space
    public char calcRepeatCharFast(String text) {
        if (Objects.isNull(text) || EMPTY.equals(text) || EMPTY.equals(text.trim())) {
            throw new IllegalArgumentException("Text should not be null");
        }

        Map<Character, Integer> container = new HashMap<>();
        char[] chars = text.toCharArray();
        int targetCount = chars.length / 2;

        for (char aChar : chars) {
            int currentSumCount = sumCountForChar(container, aChar);

            if (currentSumCount > targetCount) {
                return aChar;
            }
        }

        throw new RepeatedChatNotFoundException(text);
    }


    private int sumCountForChar(Map<Character, Integer> container, char aChar) {
        int currentCount = container.getOrDefault(aChar, 0);
        container.put(aChar, ++currentCount);
        return currentCount;
    }

    public static class RepeatedChatNotFoundException extends RuntimeException {
        private final String text;

        public RepeatedChatNotFoundException(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
