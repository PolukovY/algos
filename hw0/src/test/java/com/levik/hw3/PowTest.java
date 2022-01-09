package com.levik.hw3;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowTest {

    @Test
    public void tes1tCase() {
        //given
        int x = 2;
        int n = 3;
        int expected = 8;

        //when
        int actual = Pow.pow(x, n);

        //then
        assertEquals(expected, actual);
    }
}