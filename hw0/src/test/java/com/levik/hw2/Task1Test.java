package com.levik.hw2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class Task1Test {

    private static final byte DARK_MARK = (byte) 127;

    private Task1 testInstance;

    @Test
    public void testCase1() {
        //given
        int n = 2;
        byte[][] image = new byte[n][n];
        image[0][0] = 1;
        image[0][1] = DARK_MARK;
        image[1][0] = -1;
        image[1][1] = DARK_MARK;

        long startTime = System.nanoTime();
        testInstance = new Task1(n, image);

        /*
        [i, j] = [0, 0]
        [i, j] = [1, 0]
        [i, j] = [0, 1]
        [i, j] = [1, 1]
         */
        //when
        boolean dark = testInstance.isDarkOp1();

        long endTime = System.nanoTime();

        System.out.println("Time " +(endTime - startTime) / 1e6);

        //then
        Assert.assertFalse(dark);
    }

    /**
     * Result statistic
     * original isDark
     Time 161.892108
     Time 191.90833
     Time 142.328889
     Time 88.740585
     Time 111.625455
     Time 119.03224
     Time 119.762347
     Time 140.457042
     Time 142.970167
     Time 133.254277
     *
     * isDarkOp1
     Time 48.68938
     Time 36.100221
     Time 25.57554
     Time 9.474258
     Time 5.922604
     Time 5.795944
     Time 2.596808
     Time 27.318195
     Time 7.802304
     Time 11.69691
     *
     */
    @Test
    public void testCase2() {
        //given
        int n = 4096;
        byte[][] image = new byte[n][n];
        populateRandomImage(n, image);


        testInstance = new Task1(n, image);

        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            //when
            boolean dark = testInstance.isDarkOp1();

            long endTime = System.nanoTime();

            System.out.println("Time " +(endTime - startTime) / 1e6);
        }

    }

    private void populateRandomImage(int n, byte[][] image) {
        Random random = new Random(127);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = (byte) random.nextInt();
            }
        }
    }
}