package com.levik.hw1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task3Test {

    private Task3 testInstance;

    @Before
    public void setUp() {
        testInstance = new Task3();
    }

    @Test
    public void shouldCalcRepeatedCountFastForString() {
        //given
        String text = "fgofpdjfnvvgyfhhddddddddjsldfdddddddddddddd";
        char expectedChar = 'd';

        //when
        char actualChar = testInstance.calcRepeatCharFast(text);

        //then
        assertEquals(expectedChar, actualChar);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldCalcRepeatedCountFastForEmptyString() {
        //given
        String text = "";

        //when
        testInstance.calcRepeatCharFast(text);
    }

    @Test
    public void shouldCalcRepeatedCountFastForSimpleString() {
        //given
        String text = "llllllooooo";
        char expectedChar = 'l';

        //when
        char actualChar = testInstance.calcRepeatCharFast(text);

        //then
        assertEquals(expectedChar, actualChar);
    }

    @Test
    public void shouldCalcRepeatedCountSlowForString() {
        //given
        String text = "fgofpdjfnvvgyfhhddddddddjsldfdddddddddddddd";
        char expectedChar = 'd';

        //when
        char actualChar = testInstance.calcRepeatCharSlow(text);

        //then
        assertEquals(expectedChar, actualChar);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldCalcRepeatedCountSlowForEmptyString() {
        //given
        String text = "";

        //when
        testInstance.calcRepeatCharSlow(text);
    }

    @Test
    public void shouldCalcRepeatedCountSlowForSimpleString() {
        //given
        String text = "llllllooooo";
        char expectedChar = 'l';

        //when
        char actualChar = testInstance.calcRepeatCharSlow(text);

        //then
        assertEquals(expectedChar, actualChar);
    }
}