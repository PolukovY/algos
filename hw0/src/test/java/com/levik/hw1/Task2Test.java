package com.levik.hw1;

import org.junit.Assert;
import org.junit.Test;

public class Task2Test {

    private final Task2 testInstance = new Task2();

    @Test
    public void shouldNoTwoSlash() {
        //given
        String url = "/page1///page2////page3/test.html";
        String expectedUrl = "/page1/page2/page3/test.html";

        //when
        String actualUrl = testInstance.twoSlash(url);

        //then
        Assert.assertEquals(expectedUrl, actualUrl);
    }


    @Test
    public void shouldHandleEmptyUrl() {
        //given
        String url = "";
        String expectedUrl = "";

        //when
        String actualUrl = testInstance.twoSlash(url);

        //then
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void shouldHandleSpacesUrl() {
        //given
        String url = "   ";
        String expectedUrl = "";

        //when
        String actualUrl = testInstance.twoSlash(url);

        //then
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldHandleNullUrl() {
        //given
        String url = null;

        //when
        testInstance.twoSlash(url);
    }


}