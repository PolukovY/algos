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
                if (image[i][j] >= DARK_MARK) {
                    count += 1;
                }
            }
        }

        return count < n * n / 2;
    }

    public boolean isDarkOp1() {
        long count = 0;
        for (int k = 0; k < n*n; k++) {
            int i = k / n;
            int j = k % n;
            if (image[i][j] >= DARK_MARK) {
                count += 1;
            }
        }

        return count < n * n / 2;
    }
}
