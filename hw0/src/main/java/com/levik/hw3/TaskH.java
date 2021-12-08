package com.levik.hw3;

import java.util.Scanner;

public class TaskH {

    public static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] inputs = input.nextLine().split(SPACE);

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        Tuple[] items = new Tuple[m];
        for (int i = 0; i < m; i++) {
            String[] line = input.nextLine().split(SPACE);
            items[i] = new Tuple(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        int solution = solution(items);
        System.out.println(solution);
    }

    public static int solution(Tuple[] items) {
        return -1;
    }

    static class Tuple {
        public final int first;
        public final int second;

        Tuple(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
