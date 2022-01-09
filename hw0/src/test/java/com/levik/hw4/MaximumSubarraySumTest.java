package com.levik.hw4;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumSubarraySumTest {

    @Test
    public void testCase1() {
        //given
        int[] array = {1,-2,0,3};
        int expectedMaximumSum = 4;

        //when
        int actualMaximumSum = MaximumSubarraySum.maximumSum(array);

        //then
        Assert.assertEquals(expectedMaximumSum, actualMaximumSum);
    }

    @Test
    public void testCase2() {
        //given
        int[] array = {1,-2,-2,3};
        int expectedMaximumSum = 3;

        //when
        int actualMaximumSum = MaximumSubarraySum.maximumSum(array);

        //then
        Assert.assertEquals(expectedMaximumSum, actualMaximumSum);
    }

    @Test
    public void testCase3() {
        //given
        int[] array = {-1,-1,-1,-1};
        int expectedMaximumSum = -1;

        //when
        int actualMaximumSum = MaximumSubarraySum.maximumSum(array);

        //then
        Assert.assertEquals(expectedMaximumSum, actualMaximumSum);
    }
}