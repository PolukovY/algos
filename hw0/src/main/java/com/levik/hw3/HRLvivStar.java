package com.levik.hw3;

import java.util.*;

public class HRLvivStar {

    private static final String ENTER = "ENTER";
    private static final String LEAVE = "LEAVE";
    private static final String COUNT = "COUNT";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int baseStationCount = input.nextInt();
        int[] baseStations = readBaseStations(input, baseStationCount);
        Heap heap = new Heap(baseStations);
        int numberOfRequests = input.nextInt();
        List<Integer> currentClients = new LinkedList<>();

        for (int index = 0; index < numberOfRequests; index++) {
            String command = input.next();
            if (isCommandFound(command, ENTER)) {
                int enterIndex = input.nextInt();
                handleCommand(baseStations, command, new Tuple(enterIndex), currentClients, heap);
            } else if (isCommandFound(command, LEAVE)) {
                int leaveIndex = input.nextInt();
                handleCommand(baseStations, command, new Tuple(leaveIndex), currentClients, heap);
            } else if (isCommandFound(command, COUNT)) {
                int start = input.nextInt();
                int end = input.nextInt();
                handleCommand(baseStations, command, new Tuple(start, end), currentClients, heap);
            } else {
                throw new UnsupportedOperationException("Unsupported command " + command);
            }
        }

        print(currentClients);
    }

    public static void handleCommand(int[] baseStations, String command, Tuple value, List<Integer> currentClients, Heap heap) {
        if (isCommandFound(command, ENTER)) {
            int enterIndex = value.first;
            handleEnter(enterIndex, baseStations, heap);
        } else if (isCommandFound(command, LEAVE)) {
            int leaveIndex = value.first;
            handleLeave(leaveIndex, baseStations, heap);
        } else if (isCommandFound(command, COUNT)) {
            int start = value.first;
            int end = value.second;
            Tuple countValues = new Tuple(start, end);
            handleCount(countValues, currentClients, heap);
        } else {
            throw new UnsupportedOperationException("Unsupported command " + command);
        }
    }

    public static void print(List<Integer> clients) {
        for (Integer client : clients) {
            System.out.println(client);
        }
    }

    private static void handleCount(Tuple countValues, List<Integer> currentClients, Heap heap) {
        int sum = heap.query(countValues.first, countValues.second);
        currentClients.add(sum);
    }

    private static void handleEnter(int index, int[] baseStations, Heap heap) {
        int correctIndex = index - 1;
        int baseStation = baseStations[correctIndex];
        int newValue = ++baseStation;
        heap.update(correctIndex, newValue);
    }

    private static void handleLeave(int index, int[] baseStations, Heap heap) {
        int correctIndex = index - 1;
        int baseStation = baseStations[correctIndex];
        int newValue = --baseStation;
        heap.update(correctIndex, newValue);
    }

    private static boolean isCommandFound(String text, String prefix) {
        return text.equals(prefix);
    }

    private static int[] readBaseStations(Scanner input, int baseStationCount) {
        int[] baseStations = new int[baseStationCount];

        for (int index = 0; index < baseStationCount; index++) {
            baseStations[index] = input.nextInt();
        }

        return baseStations;
    }

    public static class Heap {
        private final int[] originalItems;
        private final int[] prefixSum;

        public Heap(int[] array) {
            this.originalItems = array;
            this.prefixSum = createPrefixSum(array);
        }

        private void updatePrefixSum(int index) {
            if (index == 0) {
                index += 1;
                prefixSum[0] = originalItems[0];
            }
            for (int i = index; i < prefixSum.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + originalItems[i];
            }
        }

        private int[] createPrefixSum(int[] array) {
            int[] prefixSum = new int[array.length];
            prefixSum[0] = array[0];

            for (int i = 1; i < array.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + array[i];
            }

            return prefixSum;
        }

        public void update(int index, int newValue) {
            originalItems[index] = newValue;
            updatePrefixSum(index);
        }

        public int query(int left, int right) {
            int start = left - 1;
            int end = right - 1;

            int rangeSum = 0;

            if (start > 0) {
                rangeSum = prefixSum[end] - prefixSum[start - 1];
            }

            if (start == 0) {
                rangeSum =  prefixSum[end];
            }

            return rangeSum;
        }
    }

    static class Tuple {
        public final int first;
        public int second;

        public Tuple(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public Tuple(int first) {
            this.first = first;
        }
    }
}
