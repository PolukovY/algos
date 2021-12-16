package com.levik.hw4;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasicCalcTest {

    @Test
    public void testCase1() {
        String input = "3+2*2";
        int expected = 7;

        int actual = new BasicCalc().calculate(input);

        assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        String input = " 3/2 ";
        int expected = 1;

        int actual = new BasicCalc().calculate(input);

        assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        String input = "42";
        int expected = 42;

        int actual = new BasicCalc().calculate(input);

        assertEquals(expected, actual);
    }
}