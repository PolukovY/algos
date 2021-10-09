package com.levik.hw1;

import java.util.Objects;

public class Task2 {
    private static final char SLASH = '/';
    private static final String EMPTY = "";

    public String twoSlash(String url) {
        if (Objects.isNull(url)) {
            throw new IllegalArgumentException("Url should not be null");
        }

        if (EMPTY.equals(url) || EMPTY.equals(url.trim())) {
            return EMPTY;
        }

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
