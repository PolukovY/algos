package com.levik.hw4;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GenerateParenthesesTest {

    @Test
    public void testCase1() {
        //given
        int n = 3;

        //when
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> strings = generateParentheses.generateParenthesis(3);

        //then
    }
}