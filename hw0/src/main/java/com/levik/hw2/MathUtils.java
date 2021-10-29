package com.levik.hw2;

public class MathUtils {

    // a / b = x
    // a = x * b;
    public static int div(int aa, int bb) {
        int a = Math.abs(aa);
        int b = Math.abs(bb);

        if (a < b) {
            return 0;
        }

        int left = -1;
        int right = Math.max(a, b);

        while (right - left > 1) {
            int m = (right + left) >>> 1;

            if (m * b >= a) {
                right = m;
            } else {
                left = m;
            }
        }

        return aa * bb >= 0 ? right : right * -1;
    }
}
