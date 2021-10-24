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

        //when
        boolean dark = testInstance.isDark();

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
     Time 93.664637
     Time 73.464787
     Time 117.229835
     Time 103.162516
     Time 74.710576
     Time 90.587888
     Time 94.889398
     Time 111.7756
     Time 93.254102
     Time 92.452103
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