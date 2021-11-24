package com.levik.hw3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskCTest {

    @Test
    public void testCase1() {
        //given
        int[] array = {2, 6, 4, 3, 6, 8, 9};
        int target = 20;
        int expectedCount = 39;

        //when
        int actualCount = TaskC.solution(array, target);

        //then
        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testCase2() {
        //given
        int[] array = {2, 6, 4, 9};
        int target = 8;
        int expectedCount = 5;

        //when
        int actualCount = TaskC.solution(array, target);

        //then
        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testCase3() {
        //given
        int[] array = {2, 6};
        int target = 2;
        int expectedCount = 1;

        //when
        int actualCount = TaskC.solution(array, target);

        //then
        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testCase4() {
        //given
        int[] array = {2, 6};
        int target = 8;
        int expectedCount = 3;

        //when
        int actualCount = TaskC.solution(array, target);

        //then
        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testCase5() {
        //given
        int[] array = {2};
        int target = 2;
        int expectedCount = 1;

        //when
        int actualCount = TaskC.solution(array, target);

        //then
        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testCase6() {
        //given
        int[] array = {2};
        int target = 1;
        int expectedCount = 0;

        //when
        int actualCount = TaskC.solution(array, target);

        //then
        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testCase7() {
        //given
        int[] array = {};
        int target = 1;
        int expectedCount = 0;

        //when
        int actualCount = TaskC.solution(array, target);

        //then
        Assert.assertEquals(expectedCount, actualCount);
    }
}