package com.levik.hw3;

import org.junit.Assert;
import org.junit.Test;

public class SquaresOfSortedArrayTest {

    @Test
    public void testCase1() {
        //given
        int[] nums = {-4,-1,0,3,10};
        //16, 1, 0, 9, 100
        int[] expectedNums = {0, 1, 9, 16, 100};

        //when
        var squaresOfSortedArray = new SquaresOfSortedArray();
        int[] actualNums = squaresOfSortedArray.sortedSquares(nums);

        Assert.assertArrayEquals(expectedNums, actualNums);
    }

    @Test
    public void testCase2() {
        //given
        int[] nums = {-7,-3,2,3,11};
        int[] expectedNums = {4,9,9,49,121};

        //when
        var squaresOfSortedArray = new SquaresOfSortedArray();
        int[] actualNums = squaresOfSortedArray.sortedSquares(nums);

        Assert.assertArrayEquals(expectedNums, actualNums);
    }

    @Test
    public void testCase3() {
        //given
        int[] nums = {-5,-3,-2,-1};
        //25, 9, 4, 1
        int[] expectedNums = {1, 4, 9, 25};

        //when
        var squaresOfSortedArray = new SquaresOfSortedArray();
        int[] actualNums = squaresOfSortedArray.sortedSquares(nums);

        Assert.assertArrayEquals(expectedNums, actualNums);
    }
}