package com.levik.hw4;

import org.junit.Test;

import static org.junit.Assert.*;

public class AllHappyStringsTest {

    @Test
    public void testCase1() {
        //given
        int n = 3;
        int k = 9;
        String expected = "cab";

        //when
        String actual = new AllHappyStrings().getHappyString(n, k);

        //then
        assertEquals(expected, actual);
    }
}