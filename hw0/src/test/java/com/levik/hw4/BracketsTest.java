package com.levik.hw4;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BracketsTest {

    @Test
    public void testCase1() {
        String text = "[{}]";

        boolean actual = Brackets.isValid(text);

        Assert.assertTrue(actual);
    }

    @Test
    public void testCase2() {
        String text = "[{]}";

        boolean actual = Brackets.isValid(text);

        Assert.assertFalse(actual);
    }
}