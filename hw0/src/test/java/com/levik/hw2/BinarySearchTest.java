package com.levik.hw2;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void shouldSearchFirstOne() {
        //given
        int[] array = {0, 0, 0, 1, 1};
        int expectedIndex = 3;

        //when
        int search = BinarySearch.search(array, 1);

        //then
        assertEquals(expectedIndex, search);
    }
}