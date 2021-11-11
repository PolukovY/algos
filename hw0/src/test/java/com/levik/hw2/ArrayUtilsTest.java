package com.levik.hw2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtilsTest {

    @Test
    public void testCase1() {
        //given
        int[] a = {2, 5, 7, 14, 100};
        int[] b = {0, 15, 20, 22};
        int[] expected = {0, 2, 5, 7, 14, 15, 20, 22, 100};

        //when
        int[] actual = ArrayUtils.marge(a, b);

        //then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        //given
        List<Integer> a = Arrays.asList(2, 5, 7, 14, 100);
        List<Integer> b = Arrays.asList(0, 15, 20, 22);
        List<Integer> expected = Arrays.asList(0, 2, 5, 7, 14, 15, 20, 22, 100);

        //when
        List<Integer> actual = ArrayUtils.marge(new ArrayList<>(a), new ArrayList<>(b));

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        //given
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6, 8};
        int[] expected = {2, 0};

        //when
        int[] actual = ArrayUtils.diff(a, b);

        //then
        Assert.assertArrayEquals(expected, actual);
    }
}