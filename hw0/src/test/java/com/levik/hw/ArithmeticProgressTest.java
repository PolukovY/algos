package com.levik.hw;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticProgressTest {

    @Test
    public void shouldCalcSumByRange() {
        //given
        int[] data = {35, 28, 21};
        int from  = 12;
        int to = 18;
        var arithmeticProgress = new ArithmeticProgress();
        int expectedSum = -441;

        //when
        int actualSum = arithmeticProgress.sum(data, from, to);

        //then
        assertEquals(expectedSum, actualSum);
    }
}