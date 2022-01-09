package com.levik.hw4;

import java.util.*;

public class Brackets {

    private static final List<Character> OPEN = Arrays.asList('{', '(', '[');
    private static final Map<Character, Character> BRACKETS = new HashMap<>() {{
        put('{', '}');
        put('(', ')');
        put('[', ']');
    }};

    public static boolean isValid(String text) {
        Stack<Character> stack = new Stack<>();
        for (char br : text.toCharArray()) {
            if (OPEN.contains(br)) {
                stack.push(br);
            } else {
                if (stack.isEmpty()){
                    return false;
                }

                Character openBr = stack.pop();
                Character closeBr = BRACKETS.get(openBr);

                if (Objects.nonNull(closeBr) && br != closeBr) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}
