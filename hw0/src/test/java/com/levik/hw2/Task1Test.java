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

    @Test
    public void testCase3() {
        //given
        int[] array = {1, 3, 0, 2};
        int x = 2;
        int expected = 23;

        //when
        long startTime = System.nanoTime();
        long actual = Task1.calcB(array, x);
        long endTime = System.nanoTime();

        System.out.println("Time " +(endTime - startTime) / 1e6);

        //then
        Assert.assertEquals(expected, actual);
    }

    /**
     * calcB
     * Time 501.912897 res 6887431068208286720
     * Time 272.098515 res 6887431068208286720
     * Time 262.676189 res 6887431068208286720
     * Time 263.413871 res 6887431068208286720
     * Time 272.46586 res 6887431068208286720
     * Time 210.61795 res 6887431068208286720
     * Time 183.967247 res 6887431068208286720
     * Time 183.956467 res 6887431068208286720
     * Time 179.251605 res 6887431068208286720
     * Time 179.942581 res 6887431068208286720
     *
     * calcBOps
     * Time 350.47566 res 6887431068208286720
     * Time 296.140056 res 6887431068208286720
     * Time 297.223755 res 6887431068208286720
     * Time 305.498102 res 6887431068208286720
     * Time 240.529082 res 6887431068208286720
     * Time 176.476125 res 6887431068208286720
     * Time 179.660099 res 6887431068208286720
     * Time 177.795409 res 6887431068208286720
     * Time 182.906869 res 6887431068208286720
     * Time 179.012713 res 6887431068208286720
     */
    @Test
    public void testCase3Time() {
        //given
        int[] array = populateRandomArray(10_000_000);
        int x = 2;

        //when
        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            long actual = Task1.calcBOps(array, x);
            long endTime = System.nanoTime();

            System.out.println("Time " +(endTime - startTime) / 1e6 + " res " + actual);
        }
    }

    private int[] populateRandomArray(int n) {
        int[] array = new int[n];
        Random random = new Random(1000);
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }

        return array;
    }
}