package com.levik.hw2;

import java.util.Scanner;

public class HRTask2 {
    public static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String[] inputs = line.split(SPACE);

        int n = Integer.parseInt(inputs[0]);
        double a = Double.parseDouble(inputs[1]);

        double actual = new Garland(n, a).solution();
        System.out.println(actual);
    }

    public static class Garland {
        private static final double PRECISION = Math.pow(10, -7);

        private final int n;
        private final double a;

        public Garland(int n, double a) {
            this.n = n;
            this.a = a;
        }

        private double heightHelper(double d, int k) {
            return a + (-d + k - 2) * (k - 1);
        }

        private double height(double d, int k) {
            return heightHelper(d, k);
        }

        private double lastHeight(double d) {
            return heightHelper(d, n);
        }

        private boolean isHitTheGround(double d) {
            int k = (int) (Math.floor(d / 2) + 2);
            return k >= n && lastHeight(d) < 0 || k < n && height(d, k) < 0;
        }

        public double solution() {
            double left = 0;
            double right = a + 1;
            double bLeft = lastHeight(left);
            double bRight = lastHeight(right);

            while (bLeft - bRight > PRECISION) {
                double mid = (left + right) / 2.0;
                if (isHitTheGround(mid)) {
                    right = mid;
                    bRight = lastHeight(right);
                } else {
                    left = mid;
                    bLeft = lastHeight(left);
                }
            }

            return bLeft;
        }
    }
}
