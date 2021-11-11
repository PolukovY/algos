package com.levik.hw2;

public class BinarySearch {

    public static int search(int[] array, int key) {
        int left = -1;
        int right = array.length;

        while (right - left > 1) {
            int m = (right + left) >>> 1;

            if (array[m] >= key) {
                right = m;
            } else {
                left = m;
            }
        }

        return array[right] == key ? right : -1;
    }
}
