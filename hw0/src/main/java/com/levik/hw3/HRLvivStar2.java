package com.levik.hw3;

import java.util.*;

public class HRLvivStar2 {

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
        int sum = heap.query(countValues.first - 1, countValues.second - 1);
        currentClients.add(sum);
    }

    private static void handleEnter(int index, int[] baseStations, Heap heap) {
        int correctIndex = index - 1;
        int baseStation = baseStations[correctIndex];
        int newValue = ++baseStation;
        baseStations[correctIndex] = newValue;
        heap.update(correctIndex, newValue);
    }

    private static void handleLeave(int index, int[] baseStations, Heap heap) {
        int correctIndex = index - 1;
        int baseStation = baseStations[correctIndex];
        int newValue = --baseStation;
        baseStations[correctIndex] = newValue;
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
        private final Integer[] tree;
        private final int[] arr;

        public Heap(int[] arr) {
            this.arr = arr;
            tree = new Integer[findArraySizeToRepresentTree(arr.length)];
            Arrays.fill(tree, null);
            createTree(arr);
        }

        public void update(int index, int updatedValue) {
            updateElementUtil(0, arr.length - 1, index, updatedValue, 0, arr);
        }

        public Integer query(int left, int right) {
            return findQueryUtil(0, 0, arr.length - 1, left, right);
        }

        private int updateElementUtil(int start, int end, int updatedIndex, int updatedValue, int index, int[] arr) {
            if (updatedIndex < start || updatedIndex > end) {
                return tree[index];
            }
            if (start == end) {
                arr[updatedIndex] = updatedValue;
                tree[index] = updatedValue;
                return updatedValue;
            }
            int mid = (start + end) >> 1;
            int l = updateElementUtil(start, mid, updatedIndex, updatedValue, 2 * index + 1, arr);
            int r = updateElementUtil(mid + 1, end, updatedIndex, updatedValue, 2 * index + 2, arr);
            tree[index] = sum(l, r);
            return tree[index];
        }

        private Integer findQueryUtil(int index, int start, int end, int left, int right) {
            if (start >= left && end <= right) {
                return tree[index];
            }
            if (end < left || start > right) {
                return null;
            }
            int mid = (start + end) >> 1;
            Integer l = findQueryUtil(2 * index + 1, start, mid, left, right);
            Integer r = findQueryUtil(2 * index + 2, mid + 1, end, left, right);
            return sum(l, r);
        }

        private void createTree(int[] arr) {
            createTreeHelper(0, 0, arr.length - 1, arr);
        }

        private int createTreeHelper(int index, int start, int end, int[] arr) {
            if (start == end) {
                tree[index] = arr[start];
                return tree[index];
            }
            int mid = (start + end) >> 1;
            int l = createTreeHelper(2 * index + 1, start, mid, arr);
            int r = createTreeHelper(2 * index + 2, mid + 1, end, arr);
            tree[index] = sum(l, r);
            return tree[index];
        }

        private int sum(Integer left, Integer right) {
            if (Objects.isNull(left)){
                return right;
            }
            if (Objects.isNull(right)) {
                return left;
            }
            return left + right;
        }

        public int findArraySizeToRepresentTree(int n) {
            double power = Math.log(n) / Math.log(2);
            if (((int) power) == power) {
                return 2 * n - 1;
            }
            int reqPower = (int) power + 1;
            return (int) Math.pow(2, reqPower) * 2 - 1;
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
