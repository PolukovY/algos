package com.levik.hw2;

import org.junit.Assert;
import org.junit.Test;

public class TupleTest {

    @Test
    public void shouldSwapTwoValues() {
        //given
        int x = 2;
        int y = 3;

        Tuple expectedTuple = new Tuple(3, 2);

        //when
        Tuple actualTuple = ArrayUtils.swap(x, y);

        //then
        Assert.assertEquals(expectedTuple, actualTuple);
    }

    @Test
    public void shouldFindMin() {
        Assert.assertEquals(2, ArrayUtils.min(2, 3));
    }

    @Test
    public void shouldFindMax() {
        Assert.assertEquals(3, ArrayUtils.max(2, 3));
    }

}