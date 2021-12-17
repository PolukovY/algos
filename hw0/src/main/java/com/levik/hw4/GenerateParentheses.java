package com.levik.hw4;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private static final String OPEN = "(";
    private static final String CLOSE = ")";

    public List<String> generateParenthesis (int n) {
        List<String> answer = new ArrayList<>();
        generateParenthesisHelper(OPEN, answer, n - 1, n);
        return answer;
    }

    private void generateParenthesisHelper(String result, List<String> answer, int open, int close) {
        if (open == 0 && close == 0) {
            answer.add(result);
            return;
        }

        if (open != 0) {
            generateParenthesisHelper(result + OPEN, answer, open - 1, close);
        }

        if (close > open) {
            generateParenthesisHelper(result + CLOSE, answer, open, close - 1);
        }
    }
}
