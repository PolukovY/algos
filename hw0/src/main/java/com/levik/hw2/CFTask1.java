package com.levik.hw2;

import java.util.Scanner;

public class CFTask1 {

    private static final int FAILED_TESTS = 0;
    private static final String RESULT = "! ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int solution = solution(n, input);

        print(RESULT + solution);
    }

    public static int solution(int n, Scanner input) {
        int left = -1;
        int right = n;

        while (right - left > 1) {
            int m = left + (right - left) / 2;

            if (isCommitBrokenBuild(m, input)) {
                right = m;
            } else {
                left = m;
            }
        }

        return right;
    }

    private static boolean isCommitBrokenBuild(int m, Scanner input) {
        print(String.valueOf(m));
        int i = input.nextInt();
        return i == FAILED_TESTS;
    }

    private static void print(String text) {
        System.out.println(text);
        System.out.flush();
    }
}
