package com.levik.hw2;

import org.junit.Assert;
import org.junit.Test;

public class YTask2Test {
    private static final String YES = "YES";
    private static final String NO = "NO";

    @Test
    public void testCase1() {
        //given
        String[] array = {"1", "7", "9"};

        //when
        String actual = YTask2.task(array);

        //then
        Assert.assertEquals(YES, actual);
    }

    @Test
    public void testCase2() {
        //given
        String[] array = {"1", "9", "7"};

        //when
        String actual = YTask2.task(array);

        //then
        Assert.assertEquals(NO, actual);
    }

    @Test
    public void testCase3() {
        //given
        String[] array = {"2", "2", "2"};

        //when
        String actual = YTask2.task(array);

        //then
        Assert.assertEquals(NO, actual);
    }
}