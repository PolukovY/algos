package com.levik.hw2;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void shouldSearchFirstOne() {
        //given
        int[] array = {1, 61, 126, 217, 2876, 6127, 39162, 98126, 712687, 1000000000};
        int expectedIndex = 2;

        //when
        int search = BinarySearch.search(array, 126);

        //then
        assertEquals(expectedIndex, search);
    }
}