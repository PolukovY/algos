package com.levik.hw2;

import org.junit.Test;

import static org.junit.Assert.*;

public class HRTask3Test {

    @Test
    public void testCase1() {
        //given
        int[] k = {3, 14, 7 , 6};
        int[] res = {0, 0, 1, 0};

        //when
        long[] solution = HRTask3.solution(k);

        //then
        assertEquals(res[0], solution[0]);
        assertEquals(res[1], solution[1]);
        assertEquals(res[2], solution[2]);
        assertEquals(res[3], solution[3]);
    }
}