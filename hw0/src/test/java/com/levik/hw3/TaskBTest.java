package com.levik.hw3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskBTest {

    @Test
    public void testCase1() {
        int[] array = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        int k = 10;
        TaskB.Tuple expected = new TaskB.Tuple(3, 3);

        TaskB.Tuple actual = TaskB.solution(array, k);

        Assert.assertEquals(expected.first, actual.first);
        Assert.assertEquals(expected.second, actual.second);
    }
}