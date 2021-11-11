package com.levik.hw3;

import org.junit.Assert;
import org.junit.Test;

public class SortArrayByParityTest {

    @Test
    public void testCase1() {
        //given
        int[] num = {3,1,2,4};
        int[] expected = {2,4,1,3};

        //when
        int[] actual = new SortArrayByParity().sortArrayByParity(num);

        //then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        //given
        int[] num = {0};
        int[] expected = {0};

        //when
        int[] actual = new SortArrayByParity().sortArrayByParity(num);

        //then
        Assert.assertArrayEquals(expected, actual);
    }

}