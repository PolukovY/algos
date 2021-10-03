package com.levik.hw;

import org.junit.Test;

import static org.junit.Assert.*;

public class GeometricProgressionTest {

    @Test
    public void shouldCalcSecondNumber() {
        //given
        int firstItem = 18;
        int thirdItem = 2;
        double delta = 0.01;

        double expectedSecondItem = 5.94;

        GeometricProgression geometricProgression = new GeometricProgression();

        //when
        double actualSecondItem = geometricProgression.calcSecondNum(firstItem, thirdItem);

        //then
        assertEquals(actualSecondItem, expectedSecondItem, delta);
    }
}