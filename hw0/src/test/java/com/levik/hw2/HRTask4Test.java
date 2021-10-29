package com.levik.hw2;

import org.junit.Test;

import static org.junit.Assert.*;

public class HRTask4Test {

    @Test
    public void testCase1() {
        //given
        double price = 6800.00;
        double monthlyPayment = 100.00;
        int loanTerm = 68;
        double expected = 0.000000000000133;

        //when
        double actual = HRTask4.solution(price, monthlyPayment, loanTerm);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testCase2() {
        //given
        double price = 2000.00;
        double monthlyPayment = 510.00;
        int loanTerm = 4;
        double expected = 9.562054624583681;

        //when
        double actual = HRTask4.solution(price, monthlyPayment, loanTerm);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testCase3() {
        //given
        double price = 15000.00;
        double monthlyPayment = 364.00;
        int loanTerm = 48;
        double expected = 7.687856394581649;

        //when
        double actual = HRTask4.solution(price, monthlyPayment, loanTerm);

        assertEquals(expected, actual, 0.0001);
    }
}