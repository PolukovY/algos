package com.levik.hw1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Task1Test {

    private Task1 testInstance;

    @Before
    public void beforeEach() {
        testInstance = new Task1();
    }

    @Test
    public void shouldCalcExample1() {
        //given
        int n = 10;
        int expectedDbCallsLessThenMultipleN = n * n;

        //when
        testInstance.example1(n);

        long dbCallCount = testInstance.getDbCallCount();

        //then
        Assert.assertTrue(expectedDbCallsLessThenMultipleN >= dbCallCount);
    }

    @Test
    public void shouldCalcExample2() {
        //given
        int n = 1_000;
        int expectedDbCallsLessThenMultipleN = n * n;

        //when
        testInstance.example2(n);

        long dbCallCount = testInstance.getDbCallCount();

        //then
        Assert.assertTrue(expectedDbCallsLessThenMultipleN >= dbCallCount);
    }

    @Test
    public void shouldCalcExample3() {
        //given
        int n = 100;
        int expectedDbCallsLessThenMultipleN = n * n;

        //when
        testInstance.example3(n);

        long dbCallCount = testInstance.getDbCallCount();

        //then
        Assert.assertTrue(expectedDbCallsLessThenMultipleN >= dbCallCount);
    }

    @Test
    public void shouldCalcExample4() {
        //given
        int n = 1000;
        int expectedDbCallsLessThenMultipleN = n * n;

        //when
        testInstance.example4(n);

        long dbCallCount = testInstance.getDbCallCount();

        //then
        Assert.assertTrue(expectedDbCallsLessThenMultipleN >= dbCallCount);
    }

    @Test
    public void shouldCalcExample5() {
        //given
        int n = 10;
        int expectedDbCallsLessThenMultipleN = n * n;

        //when
        testInstance.example5(n);

        long dbCallCount = testInstance.getDbCallCount();

        //then
        Assert.assertFalse(expectedDbCallsLessThenMultipleN >= dbCallCount);
    }

    @Test
    public void shouldCalcExample6() {
        //given
        int n = 10;
        int expectedDbCallsLessThenMultipleN = n * n;

        //when
        testInstance.example6(n);

        long dbCallCount = testInstance.getDbCallCount();

        //then
        Assert.assertFalse(expectedDbCallsLessThenMultipleN >= dbCallCount);
    }

    @Test
    public void shouldCalcExample7() {
        //given
        int n = 10;
        int expectedDbCallsLessThenMultipleN = n * n;

        //when
        testInstance.example7(n);

        long dbCallCount = testInstance.getDbCallCount();

        //then
        Assert.assertTrue(expectedDbCallsLessThenMultipleN >= dbCallCount);
    }

    @Test
    public void shouldCalcExample8() {
        //given
        int n = 10;
        int expectedDbCallsLessThenMultipleN = n * n;

        //when
        testInstance.example8(n);

        long dbCallCount = testInstance.getDbCallCount();

        //then
        Assert.assertTrue(expectedDbCallsLessThenMultipleN >= dbCallCount);
    }

    @Test
    public void shouldCalcExample9() {
        //given
        int n = 10;
        int expectedDbCallsLessThenMultipleN = n * n;

        //when
        testInstance.example9(n);

        long dbCallCount = testInstance.getDbCallCount();

        //then
        Assert.assertTrue(expectedDbCallsLessThenMultipleN >= dbCallCount);
    }
}