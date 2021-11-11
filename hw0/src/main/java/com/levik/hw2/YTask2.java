package com.levik.hw2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class YTask2 {
    public static final String INPUT_TXT = "input.txt";
    public static final String OUTPUT_TXT = "output.txt";
    public static final String SPLITERATOR = " ";
    private static final String NEXT_LINE = "\n";
    private static final String YES = "YES";
    private static final String NO = "NO";
    public static final int NOT_FOUND = -1;

    public static class Input {
        private final String firstLine;
        private final String secondLine;
        private final String thirdLine;

        public Input(String firstLine, String secondLine, String thirdLine) {
            this.firstLine = firstLine;
            this.secondLine = secondLine;
            this.thirdLine = thirdLine;
        }

        public Pair firstLine() {
            String[] items = firstLine.split(SPLITERATOR);
            return new Pair(Integer.parseInt(items[0]), Integer.parseInt(items[1]));
        }

        public int[] secondLine() {
            String[] items = secondLine.split(SPLITERATOR);
            return convert(items);
        }

        public int[] thirdLine() {
            String[] items = thirdLine.split(SPLITERATOR);
            return convert(items);
        }

        private static int[] convert(String[] nums) {
            int[] numbers = new int[nums.length];
            for (int i = 0; i< nums.length; i++) {
                numbers[i] = Integer.parseInt(nums[i]);
            }
            return numbers;
        }
    }

    public static class Pair {
        private final int first;
        private final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }

    private static Input readDataFromFile() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_TXT))) {
            String firstLine = bufferedReader.readLine();
            String secondLine = bufferedReader.readLine();
            String thirdLine = bufferedReader.readLine();
            return new Input(firstLine, secondLine, thirdLine);
        }
    }

    private static void writeDataToFile(Object obj) throws IOException {
        try (FileWriter writer = new FileWriter(OUTPUT_TXT)){
            writer.write(String.valueOf(obj));
        }
    }

    public static String[] task(Input input) {
        int[] nArray = input.secondLine();
        int[] kArray = input.thirdLine();
        return search(nArray, kArray);
    }

    private static String[] search(int[] nArray, int[] kArray) {
        Arrays.sort(nArray);
        String[] res = new String[kArray.length];

        for (int i = 0; i < kArray.length; i++) {
            int key = kArray[i];
            int index = binarySearch(nArray, key);
            res[i] = isIndexFound(index);
        }

        return res;
    }

    private static int binarySearch(int[] array, int key) {
        int left = -1;
        int right = array.length - 1;

        while (right - left > 1) {
            int m = right + left >>> 1;

            if (array[m] >= key) {
                right = m;
            } else {
                left = m;
            }
        }

        return array[right] == key ? right : NOT_FOUND;
    }

    private static String isIndexFound(int index) {
        return index == NOT_FOUND ? NO : YES;
    }

    public static void main(String[] args) throws IOException {
        Input input = readDataFromFile();

        String[] res = task(input);
        String text = String.join(NEXT_LINE, res);

        writeDataToFile(text);
    }
}
