package com.levik.hw4;

import java.util.ArrayList;
import java.util.List;

public class AllHappyStrings {

    private static final String EMPTY = "";
    private static final char[] LETTERS = {'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        List<String> combinations = new ArrayList<>();
        solution(EMPTY, combinations, n, k);
        return combinations.size() < k ? EMPTY : combinations.get(k  - 1);
    }

    private void solution(String combination, List<String> combinations, int n, int k) {
        //System.out.println("combination " + combination);
        if (combinations.size() == k) {
            return;
        }

        if (combination.length() == n) {
            //System.out.println(combination);
            combinations.add(combination);
            return;
        }

        for (char letter : LETTERS) {
            if (combination.isEmpty() || combination.charAt(combination.length() - 1) != letter) {
                solution(combination + letter, combinations, n, k);
            }
        }
    }
}
