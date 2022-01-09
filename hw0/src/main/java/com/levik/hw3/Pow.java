package com.levik.hw3;

public class Pow {

    public static int pow(int x, int n) {
        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans *= x;
        }

        return ans;
    }
}
