package com.levik.hw2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HRTask1Test {

    @Test
    public void testCase1() {
        //given
        int money = 4;
        int[] costs = {1, 4, 5, 3, 2};
        int[] expectedItems = {1, 4};

        //when
        int[] actual = HRTask1.solution(costs, money);

        //then
        Assert.assertEquals(expectedItems[0], actual[0]);
        Assert.assertEquals(expectedItems[1], actual[1]);
    }

    @Test
    public void testCase6() {
        //given
        int money = 0;
        int[] costs = {0, 0, 1, 2, 3};
        int[] expectedItems = {1, 2};

        //when
        int[] actual = HRTask1.solution(costs, money);

        //then
        Assert.assertEquals(expectedItems[0], actual[0]);
        Assert.assertEquals(expectedItems[1], actual[1]);
    }

    @Test
    public void testCase7() {
        //given
        int money = 0;
        int[] costs = {0, 0, 1, 2, 3};
        int[] expectedItems = {1, 2};

        //when
        int[] actual = HRTask1.solution2(costs, money);

        //then
        Assert.assertEquals(expectedItems[0], actual[0]);
        Assert.assertEquals(expectedItems[1], actual[1]);
    }

    @Test
    public void testCase5() {
        //given
        int money = 8;
        int[] costs = {1, 3, 5, 7};
        int[] expectedItems = {1, 4};

        //when
        int[] actual = HRTask1.solution(costs, money);

        //then
        Assert.assertEquals(expectedItems[0], actual[0]);
        Assert.assertEquals(expectedItems[1], actual[1]);
    }

    @Test
    public void testCase2() {
        //given
        int money = 4;
        int[] costs = {2, 2, 4, 3};
        int[] expectedItems = {1, 2};

        //when
        int[] actual = HRTask1.solution(costs, money);

        //then
        Assert.assertEquals(expectedItems[0], actual[0]);
        Assert.assertEquals(expectedItems[1], actual[1]);
    }

    @Test
    public void testCase3() {
        //given
        int money = 4;
        int[] costs = {1, 4, 5, 3, 2};
        int[] expectedItems = {1, 4};

        //when
        int[] actual = HRTask1.solution2(costs, money);

        //then
        Assert.assertEquals(expectedItems[0], actual[0]);
        Assert.assertEquals(expectedItems[1], actual[1]);
    }

    @Test
    public void testCase4() {
        //given
        int money = 4;
        int[] costs = {2, 2, 4, 3};
        int[] expectedItems = {1, 2};

        //when
        int[] actual = HRTask1.solution2(costs, money);

        //then
        Assert.assertEquals(expectedItems[0], actual[0]);
        Assert.assertEquals(expectedItems[1], actual[1]);
    }



    @Test
    public void testTraceBugs() {
        int testCaseNum = 0;
        while (true) {
            Random random = new Random();
            int money = random.nextInt(10);

            int[] costs = randomItems();
            int[] expectedItems = HRTask1.solution2(costs, money);


            //when
            int[] actual = HRTask1.solution(costs, money);


            //then
            if (expectedItems.length == 2 & actual.length == 2) {
                try {
                    Assert.assertEquals(expectedItems[1], actual[1]);
                    Assert.assertEquals(expectedItems[0], actual[0]);
                } catch (AssertionError exe) {
                    if (costs[actual[1]] + costs[actual[0]] != money) {
                        System.out.println("testCaseNum : " + testCaseNum++ );
                        System.out.println("money : " + money + " costs : " + Arrays.toString(costs));
                        System.out.println();
                        System.out.println("expectedItems : " + Arrays.toString(expectedItems));
                        System.out.println("actual : " + Arrays.toString(actual));
                        System.out.println();
                        throw exe;
                    }
                }
            }
        }
    }

    private int[] randomItems() {
        Random random = new Random();
        int n = random.nextInt(10);
        Set<Integer> costs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = random.nextInt(10);
            if (num > 0) {
                costs.add(num);
            }
        }

        return costs.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}