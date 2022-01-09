package com.levik.hw4;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void testCase1() {
        int fib = Fibonacci.fib(0);
        assertEquals(0, fib);
    }

    @Test
    public void testCase2() {
        int fib = Fibonacci.fib(9);
        assertEquals(34, fib);
    }

    @Test
    public void testCase3() {
        int fib = Fibonacci.fibOptimal(0);
        assertEquals(0, fib);
    }

    @Test
    public void testCase4() {
        int fib = Fibonacci.fibOptimal(9);
        assertEquals(34, fib);
    }

    @Test
    public void testCase5() {
        int fib = Fibonacci.fibSlow(0);
        assertEquals(0, fib);
    }

    @Test
    public void testCase6() {
        int fib = Fibonacci.fibSlow(9);
        assertEquals(34, fib);
    }
}