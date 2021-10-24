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
    public void shouldCalcExample2() {
        //given
        int n = 100;
        int expectedDbCallsLessThenMultipleN = n * n;

        //when
        testInstance.exampleA(n);

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
        testInstance.exampleB(n);

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
        testInstance.exampleC(n);

        long dbCallCount = testInstance.getDbCallCount();

        //then
        Assert.assertTrue(expectedDbCallsLessThenMultipleN >= dbCallCount);
    }

    @Test
    public void shouldCalcExample5() {
        //given
        int n = 5;
        int expectedDbCallsLessThenMultipleN = n * n;

        //when
        testInstance.exampleD(n);

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
        testInstance.exampleE(n);

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
        testInstance.exampleF(n);

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
        testInstance.exampleG(n);

        long dbCallCount = testInstance.getDbCallCount();

        //then
        Assert.assertTrue(expectedDbCallsLessThenMultipleN >= dbCallCount);
    }

    @Test
    public void shouldCalcExample9() {
        //given
        int n = 4;
        int expectedDbCallsLessThenMultipleN = n * n;

        //when
        testInstance.exampleH(n);

        long dbCallCount = testInstance.getDbCallCount();

        //then
        Assert.assertTrue(expectedDbCallsLessThenMultipleN >= dbCallCount);
    }
}