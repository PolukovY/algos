package com.levik.hw1;

public class Task2 {
    private static final char SLASH = '/';

    public String twoSlash(String url) {
        char[] chars = url.toCharArray();
        var result = new StringBuilder();

        for (int i = 0; i < chars.length - 1; i++) {
            char firstChar = chars[i];
            char nextChar = chars[i + 1];

            if (firstChar == SLASH && nextChar == SLASH) {
                continue;
            }

            result.append(firstChar);
        }

        result.append(chars[chars.length - 1]);
        return result.toString();
    }
}
