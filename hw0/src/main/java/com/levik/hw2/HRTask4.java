package com.levik.hw2;

import java.util.Scanner;

public class HRTask4 {

    public static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String[] inputs = line.split(SPACE);

        double price = Double.parseDouble(inputs[0]);
        double monthlyPayment = Double.parseDouble(inputs[1]);
        int loanTerm = Integer.parseInt(inputs[2]);

        double solution = solution(price, monthlyPayment, loanTerm);

        System.out.println(solution);
    }

    public static double solution(double price, double monthlyPayment, int loanTerm) {
        double left = 0;
        double right = 100;
        double m = (right + left) / 2.0;
        while (right != m && left != m) {
            double current = price;

            for (int i = 0; i < loanTerm; i++) {
                current =  current * (1 + m / 100.0 / 12) - monthlyPayment;
            }

            if (current <= 0) {
                left = m;
            } else {
                right = m;
            }

            m = (right + left) / 2.0;
        }

        return left;
    }
}
