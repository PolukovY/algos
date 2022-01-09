package com.levik.hw5;

import org.junit.Assert;
import org.junit.Test;

public class PlayGameTest {

    @Test
    public void testCase1() {
        //given
        int[] playerArmy = {5, 15, 100, 1, 5};
        int[] computerArmy = {5, 15, 100, 1, 5};
        int expected = 120;

        //when
        int actual = PlayGame.solution(playerArmy, computerArmy);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        //given
        int[] playerArmy = {50, 50, 50, 50, 50};
        int[] computerArmy = {50, 50, 50, 50, 50};
        int expected = 0;

        //when
        int actual = PlayGame.solution(playerArmy, computerArmy);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        //given
        int[] playerArmy = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int[] computerArmy = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int expected = 99;

        //when
        int actual = PlayGame.solution(playerArmy, computerArmy);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        //given
        int[] playerArmy = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] computerArmy = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int expected = 65;

        //when
        int actual = PlayGame.solution(playerArmy, computerArmy);

        //then
        Assert.assertEquals(expected, actual);
    }

}