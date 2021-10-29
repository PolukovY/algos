package com.levik.hw2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathUtilsTest {

    @Test
    public void testCase1() {
        int div = MathUtils.div(4, 2);
        assertEquals(2, div);
    }

    @Test
    public void testCase2() {
        int div = MathUtils.div(-4, 2);
        assertEquals(-2, div);
    }
}