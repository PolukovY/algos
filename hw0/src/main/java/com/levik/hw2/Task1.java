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
}
