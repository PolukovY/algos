package com.levik.hw5;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductsMatrixTest {

    @Test
    public void testCase1() {
        //given
        int n = 3;
        int k = 7;
        int expected = 6;

        //when
        int actual = ProductsMatrix.solution(n, k);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        //given
        int n = 2;
        int k = 4;
        int expected = 4;

        //when
        int actual = ProductsMatrix.solution(n, k);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        //given
        int n = 3;
        int k = 8;
        int expected = 6;

        //when
        int actual = ProductsMatrix.solution(n, k);

        //then
        assertEquals(expected, actual);
    }
}