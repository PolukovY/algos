package com.levik.hw4;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TaskBTest {

    @Test
    public void testCase1() {
        List<TaskB.Tuple> dictionary = Arrays.asList(
                new TaskB.Tuple("Hello", "Hi"),
                new TaskB.Tuple("Bye", "Goodbye"),
                new TaskB.Tuple("List", " Array")
        );
        String word = "Goodbye";

        String expected = "Bye";

        String actual = TaskB.solution(dictionary, word);

        assertEquals(expected, actual);

    }
}