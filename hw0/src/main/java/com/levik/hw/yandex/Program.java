package com.levik.hw.yandex;

import java.io.*;

public class Program {
    public static final String INPUT_TXT = "input.txt";
    public static final String OUTPUT_TXT = "output.txt";
    public static final String SPLITERATOR = " ";

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

    public static int task(String[] nums) {
        int sum = 0;

        for (String num : nums) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        String[] nums = readDataFromFile().split(SPLITERATOR);

        int sum = task(nums);

        writeDataToFile(sum);
    }
}
