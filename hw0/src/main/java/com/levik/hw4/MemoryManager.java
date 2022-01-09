package com.levik.hw4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.*;

public class MemoryManager {

    private static final String ENTER = "\n";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] commands = getCommand(input, m);

        List<Integer> memory = solution(n, commands);

        String result = memory.stream()
                .map(String::valueOf)
                .collect(joining(ENTER));

        System.out.println(result);
    }

    public static List<Integer> solution(int n, int[] commands) {
        List<Integer> memory = new ArrayList<>();
        int num = 1;
        memory.add(1);

        for (int command: commands) {
            if (num > n) {
                memory.add(-1);
                continue;
            }

            if (command > 0) {
                num += command;
            } else {
                int findCommandIndex = Math.abs(command) - 1;
                int undoCommand = commands[findCommandIndex] + 3;
                num += undoCommand;
            }

            memory.add(num);
        }

        return memory;
    }

    private static int[] getCommand(Scanner input, int n) {
        int[] commands = new int[n];

        for (int index = 0; index < n; index++) {
            commands[index] = input.nextInt();
        }

        return commands;
    }
}
