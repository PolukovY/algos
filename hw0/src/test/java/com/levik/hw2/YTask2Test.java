package com.levik.hw2;

import org.junit.Test;

import static org.junit.Assert.*;

public class YTask2Test {

    private static final String YES = "YES";
    private static final String NO = "NO";

    @Test
    public void testCase1() {
        //given
        String firstLine = "10 10";
        String secondLine = "1 61 126 217 2876 6127 39162 98126 712687 1000000000";
        String thirdLine = "100 6127 1 61 200 -10000 1 217 10000 1000000000";
        YTask2.Input input = new YTask2.Input(firstLine, secondLine, thirdLine);

        String[] expected = {NO, YES, YES, YES, NO, NO, YES, YES, NO, YES};

        //when
        String[] actual = YTask2.task(input);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        //given
        String firstLine = "10 10";
        String secondLine = "-8 -6 -4 -4 -2 -1 0 2 3 3";
        String thirdLine = "8 3 -3 -2 2 -1 2 9 -8 0";
        YTask2.Input input = new YTask2.Input(firstLine, secondLine, thirdLine);

        String[] expected = {NO, YES, NO, YES, YES, YES, YES, NO, YES, YES};

        //when
        String[] actual = YTask2.task(input);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        //given
        String firstLine = "10 5";
        String secondLine = "1 2 3 4 5 6 7 8 9 10";
        String thirdLine = "-2 0 4 9 12";
        YTask2.Input input = new YTask2.Input(firstLine, secondLine, thirdLine);

        String[] expected = {NO, NO, YES, YES, NO};

        //when
        String[] actual = YTask2.task(input);

        //then
        assertArrayEquals(expected, actual);
    }

}