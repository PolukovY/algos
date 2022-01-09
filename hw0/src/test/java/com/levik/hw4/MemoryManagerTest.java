package com.levik.hw4;

import org.junit.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MemoryManagerTest {

    @Test
    public void testCase1() {
        //given
        int n = 42;
        int[] commands = {7, 3, 8, -2, 6, 5, -5, 9, 4};
        List<Integer> memory = Arrays.asList(1, 8, 11, 19, 25, 30, 19);

        //when
        List<Integer> actual = MemoryManager.solution(n, commands);

        //then
        assertArrayEquals(memory.toArray(), actual.toArray());
    }
}