package com.levik.hw5;

import java.util.Arrays;
import java.util.Scanner;

public class PlayGame {

    private static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputs = input.nextLine();

        int n = Integer.parseInt(inputs);
        int[] playerArmy = getArmy(n, input);
        int[] computerArmy = getArmy(n, input);

        int maximumTotalStrength = solution(playerArmy, computerArmy);
        System.out.println(maximumTotalStrength);
    }

    public static int solution(int[] playerArmy, int[] computerArmy) {
        Arrays.sort(playerArmy);
        Arrays.sort(computerArmy);

        int sum = 0;
        int left = 0;
        int right = playerArmy.length - 1;

        for(int i = computerArmy.length - 1; i >= 0; i--) {
            int computerUnit = computerArmy[i];
            int playerUnit = playerArmy[right];

            if (playerUnit > computerUnit) {
                sum += playerUnit;
                right--;
            } else {
                playerUnit = playerArmy[left];
                if (playerUnit <= computerUnit) {
                    left++;
                } else {
                    sum += playerUnit;
                }
            }
        }

        return sum;
    }

    private static int[] getArmy(int n, Scanner input) {
        int[] army = new int[n];

        String[] inputs = input.nextLine().split(SPACE);
        for (int i = 0; i < inputs.length; i++) {
            army[i] = Integer.parseInt(inputs[i]);
        }

        return army;
    }
}
