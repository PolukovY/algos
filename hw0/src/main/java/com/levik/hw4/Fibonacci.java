package com.levik.hw4;

public class Fibonacci {

    private static final double SQRT_FIVE = Math.sqrt(5);
    private static final double PHI = (SQRT_FIVE + 1) / 2;

    /**
     *                           fib(5)
     *                      /                \
     *                fib(4)                fib(3)
     *              /        \              /       \
     *          fib(3)      fib(2)         fib(2)   fib(1)
     *         /    \       /    \        /      \
     *   fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
     *   /     \
     * fib(1) fib(0)
     */
    //O(n) - time O(n) - space
    public static int fibSlow(int n) {
        if (n <= 1) {
            return n;
        }
        return fibSlow(n-1) + fibSlow(n-2);
    }

    //O(n) - time O(1) - space
    public static int fib(int n) {
        int a = 0;
        int b = 1;
        int c;

        if (n == 0) {
            return a;
        }

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    //O(long(n)) - time O(1) - space
    public static int fibOptimal(int n) {
        return (int) Math.round(Math.pow(PHI, n) / SQRT_FIVE);
    }
}
