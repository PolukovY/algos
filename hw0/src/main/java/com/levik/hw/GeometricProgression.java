package com.levik.hw;

public class GeometricProgression {

    public double calcSecondNum(double firstItem, double thirdItem) {
        if (firstItem == 0) {
            throw new IllegalArgumentException("firstItem should not be null");
        }

        double div = thirdItem / firstItem;
        double q = Math.sqrt(div);

        return firstItem * q;
    }
}
