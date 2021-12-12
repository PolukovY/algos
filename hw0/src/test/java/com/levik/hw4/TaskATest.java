package com.levik.hw4;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TaskATest {

    @Test
    public void testCase1() {
        //given
        int k = 3;
        int[] items = {1, 3, 2, 4, 5, 3, 1};
        List<Integer> expected = Arrays.asList(1, 2, 2, 3, 1);

        //when
        List<Integer> actual = TaskA.solution(items, k);

        //then
        assertEquals(actual, expected);
    }
}