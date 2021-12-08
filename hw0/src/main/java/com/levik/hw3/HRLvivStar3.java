package com.levik.hw3;

import java.util.*;

public class HRLvivStar3 {

    private static final String ENTER = "ENTER";
    private static final String LEAVE = "LEAVE";
    private static final String COUNT = "COUNT";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int baseStationCount = input.nextInt();
        int[] baseStations = readBaseStations(input, baseStationCount);
        Heap heap = new Heap(baseStations);
        int numberOfRequests = input.nextInt();
        List<Long> currentClients = new LinkedList<>();

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

    public static void handleCommand(int[] baseStations, String command, Tuple value, List<Long> currentClients, Heap heap) {
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

    public static void print(List<Long> clients) {
        clients.forEach(System.out::println);
    }

    private static void handleCount(Tuple countValues, List<Long> currentClients, Heap heap) {
        long sum = heap.query(countValues.first - 1, countValues.second - 1);
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
        private final int partition;
        private final int[] originalItems;
        private final int[] partitionItems;

        public Heap(int[] array){
            this.originalItems = array;
            this.partition = (int) Math.sqrt(array.length) + 1;
            this.partitionItems = createPartitions();
        }

        public int[] createPartitions() {
            int[] partitions = new int[partition];

            for(int i = 0; i < originalItems.length; ++i) {
                int selectPartition = i / partition;
                partitions[selectPartition] += originalItems[i];
            }

            return partitions;
        }

        public void update(int index, int newValue) {
            int oldValue = originalItems[index];
            originalItems[index] = newValue;
            updateHelper(index, newValue, oldValue);
        }

        private void updateHelper(int index, int newValue, int oldValue) {
            int selectBlock = index / partition;

            partitionItems[selectBlock] -= oldValue;
            partitionItems[selectBlock] += newValue;
        }

        public long query(int left, int right) {
            int leftBlock = left / partition;
            int rightBlock = right / partition;

            if (left == right) {
                return sum(left, right);
            }

            int leftBlockBoarder = (leftBlock + 1) * partition;
            long sum = sum(left, leftBlockBoarder);

            for (int i = leftBlock + 1; i < rightBlock; ++i) {
                sum += partitionItems[i];
            }

            int rightBlockBoarder = rightBlock * partition;
            for (int i = right - 1; i >= rightBlockBoarder; --i) {
                sum += originalItems[i];
            }

            return sum;
        }

        private long sum(int left, int right) {
            long sum = 0;
            for (int i = left; i < right; i++) {
                sum += originalItems[i];
            }
            return sum;
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

