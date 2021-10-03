package com.levik.hw;

public class ArithmeticProgress {

    public int sum(int [] data, int from, int to) {
        if (data.length < 1) {
            return -1;
        }
        int firstNumber = data[0];
        int secondNumber = data[1];

        int step = secondNumber - firstNumber;

        int sum = 0;
        for (int i = from; i <= to; i++) {
            int num = firstNumber + (i - 1) * step;
            sum +=num;
        }

        return sum;
    }
}
