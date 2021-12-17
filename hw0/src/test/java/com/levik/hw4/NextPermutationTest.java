package com.levik.hw4;

import org.junit.Test;

import static org.junit.Assert.*;

public class NextPermutationTest {

    @Test
    public void testCase1() {
        //given
        int[] nums = {1,2,3};
        int[] expected = {1,3,2};

        //when
        new NextPermutation().nextPermutation(nums);

        //then
        for(int i = 0; i < nums.length - 1; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }
}