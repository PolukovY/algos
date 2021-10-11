package com.levik.hw1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task3Test {

    private Task3 testInstance;

    @Before
    public void setUp() {
        testInstance = new Task3();
    }

    @Test
    public void shouldCalcRepeatedCountFastForString() {
        //given
        int[] nums = new int [] {3,2,3};
        int expectedNum = 3;

        //when
        int actualNum = testInstance.calcRepeatCharFast(nums);

        //then
        assertEquals(expectedNum, actualNum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldCalcRepeatedCountFastForEmptyString() {
        //given
        int[] nums = new int [] {};

        //when
        testInstance.calcRepeatCharFast(nums);
    }

    @Test
    public void shouldCalcRepeatedCountFastForSimpleString() {
        //given
        int[] nums = new int [] {2,2,1,1,1,2,2};
        int expectedNum = 2;

        //when
        int actualNum = testInstance.calcRepeatCharFast(nums);

        //then
        assertEquals(expectedNum, actualNum);
    }

    @Test
    public void shouldCalcRepeatedCountSlowForString() {
        //given
        int[] nums = new int [] {3,2,3};
        int expectedNum = 3;

        //when
        int actualNum = testInstance.calcRepeatCharSlow(nums);

        //then
        assertEquals(expectedNum, actualNum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldCalcRepeatedCountSlowForEmptyString() {
        //given
        int[] nums = new int [] {};

        //when
        testInstance.calcRepeatCharSlow(nums);
    }

    @Test
    public void shouldCalcRepeatedCountSlowForSimpleString() {
        //given
        int[] nums = new int [] {2,2,1,1,1,2,2};
        int expectedNum = 2;

        //when
        int actualNum = testInstance.calcRepeatCharSlow(nums);

        //then
        assertEquals(expectedNum, actualNum);
    }

    @Test
    public void shouldCalcRepeatedCountSlowOneInput() {
        //given
        int[] nums = new int [] {1};
        int expectedNum = 1;

        //when
        int actualNum = testInstance.calcRepeatCharSlow(nums);

        //then
        assertEquals(expectedNum, actualNum);
    }
}