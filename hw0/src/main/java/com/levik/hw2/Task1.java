package com.levik.hw2;

public class Task1 {

    private static final byte DARK_MARK = (byte) 127;

    private final int n;
    private final byte[][] image;

    public Task1(int n, byte[][] image) {
        this.n = n;
        this.image = image;
    }

    public boolean isDark() {
        long count = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                System.out.println("[i, j] = [" + i + ", " + j + "]");
                if (image[i][j] >= DARK_MARK) {
                    count += 1;
                }
            }
        }

        return count < n * n / 2;
    }

    public boolean isDarkOp1() {
        long count = 0;
        int m = n  / 2;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < m; j++) {
                if (image[i][j] >= DARK_MARK) {
                    count += 1;
                }
            }

            for (int j = m; j < n; j++) {
                if (image[i][j] >= DARK_MARK) {
                    count += 1;
                }
            }
        }

        return count < n * n / 2;
    }

    public void sinx(int n, int terms, float[] x, float[] result) {
        for (int i = 0;  i < n; i++) {
            float value = x[i];
            float numer = x[i] * x[i] * x[i];
            int denom = 6;
            int sign = -1;

            for (int j = 1; j <= terms; j++) {
                value += sign *numer / denom;
                numer *= x[i] * x[i];
                denom *= (2*j + 2) * (2*j + 2);
                sign *= -1;
            }

            result[i] = value;
        }
    }

    public void sinxOp1(int n, int terms, float[] x, float[] result) {
        int m = terms  / 2;

        for (int i = 0;  i < n; i++) {
            float value = x[i];
            float multipleTwoNums = value * value;
            float numer = multipleTwoNums * value;
            int denom = 6;
            int sign = -1;

            for (int j = 1; j < m; j++) {
                value += sign * numer / denom;
                numer *= multipleTwoNums;
                denom *= (2*j + 2) * (2*j + 2);
                sign *= -1;
            }

            for (int j = m; j <= terms; j++) {
                value += sign * numer / denom;
                numer *= multipleTwoNums;
                denom *= (2*j + 2) * (2*j + 2);
                sign *= -1;
            }

            result[i] = value;
        }
    }

    /**
     *  2*x^3 + 3*x + 1
     */
    public static long calcB(int[] items, int x) {
        long y = 0;

        for (int i = items.length - 1; i >= 0; i--) {
            y += items[i] * Math.pow(x, i);
        }

        return y;
    }

    public static long calcBOps(int[] items, int x) {
        long y = 0;
        int m = items.length / 2;

        for (int i = items.length - 1; i > m; i--) {
            y += items[i] * Math.pow(x, i);
        }

        for (int i = m; i >= 0; i--) {
            y += items[i] * Math.pow(x, i);
        }

        return y;
    }
}
