package com.levik.hw5;

import org.junit.Test;

import static org.junit.Assert.*;

public class HRRGBStreetTest {

    @Test
    public void testCase1() {
        //given
        int n = 3;
        int[][] costs = {
                { 1, 100, 100 },
                { 100, 1, 100 },
                { 100, 100, 1 }
        };
        int expectedTotalCosts = 3;

        //when
        int totalCosts = HRRGBStreet.solution(n, costs);

        //then
        assertEquals(expectedTotalCosts, totalCosts);
    }

    @Test
    public void testCase2() {
        //given
        int n = 3;
        int[][] costs = {
                { 26, 40, 83 },
                { 49, 60, 57 },
                { 13, 89, 99 }
        };
        int expectedTotalCosts = 96;

        //when
        int totalCosts = HRRGBStreet.solution(n, costs);

        //then
        assertEquals(expectedTotalCosts, totalCosts);
    }

    @Test
    public void testCase3() {
        //given
        int n = 6;
        int[][] costs = {
                { 30, 19, 5 },
                { 64, 77, 64 },
                { 15, 19, 97 },
                { 4, 71, 57 },
                { 90, 86, 84 },
                { 93, 32, 91 }
        };
        int expectedTotalCosts = 208;

        //when
        int totalCosts = HRRGBStreet.solution(n, costs);

        //then
        assertEquals(expectedTotalCosts, totalCosts);
    }
}