package com.levik.hw2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class YTask1 {
    public static final String INPUT_TXT = "input.txt";
    public static final String OUTPUT_TXT = "output.txt";
    public static final String SPLITERATOR = " ";
    private static final String YES = "YES";
    private static final String NO = "NO";

    private static String readDataFromFile() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_TXT))) {
            return bufferedReader.readLine();
        }
    }

    private static void writeDataToFile(Object obj) throws IOException {
        try (FileWriter writer = new FileWriter(OUTPUT_TXT)){
            writer.write(String.valueOf(obj));
        }
    }

    private static int[] convert(String[] nums) {
        int[] numbers = new int[nums.length + 1];
        for (int i = 0; i< nums.length; i++) {
            numbers[i] = Integer.parseInt(nums[i]);
        }
        numbers[numbers.length - 1] = Integer.MAX_VALUE;
        return numbers;
    }

    public static String task(String[] nums) {
        int[] numbers = convert(nums);
        return search(numbers) ? YES :  NO;
    }

    private static boolean search(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        String[] nums = readDataFromFile().split(SPLITERATOR);

        String res = task(nums);

        writeDataToFile(res);
    }
}
