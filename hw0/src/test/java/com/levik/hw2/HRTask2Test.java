package com.levik.hw2;

import org.junit.Test;

import static org.junit.Assert.*;

public class HRTask2Test {

    @Test
    public void testCase1() {
        //given
        int n = 8;
        int a = 15;
        double expectedResult = 9.75;

        //when
        HRTask2.Garland garland = new HRTask2.Garland(n, a);
        double actual = garland.solution();

        //then
        assertEquals(expectedResult, actual, 0.001);
    }

    @Test
    public void testCase2() {
        //given
        int n = 692;
        double a = 532.81;
        double expectedResult = 446113.344348;

        //when
        HRTask2.Garland garland = new HRTask2.Garland(n, a);
        double actual = garland.solution();

        //then
        assertEquals(expectedResult, actual, 0.001);
    }
}