package com.levik.hw2;

import java.util.*;

public class CFTask1 {

    private static final int FAILED_TESTS = 0;
    private static final String RESULT = "! ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = read(input);

        int solution = solution(n, input);

        print(RESULT + solution);
    }

    public static int solution(int n, Scanner input) {
        Map<Integer, Boolean> cache = new HashMap<>();

        int left = 0;
        int right = n;

        while (right - left > 1) {
            int m = left + (right - left) / 2;

            if (isCommitBrokenBuildWithCacheResults(m, input, cache)) {
                right = m;
            } else {
                left = m;
            }
        }

        return right;
    }

    private static boolean isCommitBrokenBuildWithCacheResults(int m, Scanner input, Map<Integer, Boolean> cache) {
        Boolean value = cache.get(m);
        if (Objects.nonNull(value)) {
            return value;
        }

        boolean commitBrokenBuild = isCommitBrokenBuild(m, input);
        cache.put(m, commitBrokenBuild);
        return commitBrokenBuild;
    }

    private static boolean isCommitBrokenBuild(int m, Scanner input) {
        print(String.valueOf(m));
        int i = read(input);
        return i == FAILED_TESTS;
    }

    private static void print(String text) {
        System.out.println(text);
        System.out.flush();
    }

    private static int read(Scanner input) {
        return input.nextInt();
    }
}
