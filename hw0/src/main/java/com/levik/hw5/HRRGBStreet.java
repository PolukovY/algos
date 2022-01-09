package com.levik.hw5;

import java.util.Scanner;

import static java.lang.Math.*;

public class HRRGBStreet {

    private static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputs = input.nextLine();

        int n = Integer.parseInt(inputs);

        int[][] costs = getCosts(n, input);

        int totalCosts = solution(n, costs);
        System.out.println(totalCosts);
    }

    //Time - O(n), Space - O(n)
    public static int solution(int n, int[][] costs) {
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        return min(dp[n - 1][0], min(dp[n - 1][1], dp[n - 1][2]));
    }

    private static int[][] getCosts(int n, Scanner input) {
        int[][] costs = new int[n][3];

        for(int i = 0; i < n; i++) {
            String[] line = input.nextLine().split(SPACE);

            for(int j = 0; j < line.length; j++) {
                costs[i][j] = Integer.parseInt(line[j]);
            }
        }

        return costs;
    }
}
