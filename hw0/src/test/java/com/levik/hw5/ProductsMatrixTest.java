package com.levik.hw5;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductsMatrixTest {

    @Test
    public void testCase1() {
        //given
        int n = 3;
        int k = 7;
        long expected = 6;

        //when
        long actual = ProductsMatrix.solution(n, k);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        //given
        int n = 2;
        int k = 4;
        long expected = 4;

        //when
        long actual = ProductsMatrix.solution(n, k);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        //given
        int n = 3;
        int k = 8;
        long expected = 6;

        //when
        long actual = ProductsMatrix.solution(n, k);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        //given
        int n = 3;
        int k = 7;
        long expected = 6;

        //when
        long actual = ProductsMatrix2.solution(n, k);

        //then
        assertEquals(expected, actual);
    }
}