package com.levik.hw4;

import java.util.*;

public class TaskB {

    private static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        List<Tuple> dictionary = populateDictionary(input, n);
        String word = input.next();

        String synonym = solution(dictionary, word);

        System.out.println(synonym);
    }

    public static String solution(List<Tuple> input, String word) {
        Map<String, String> dictionary = createDictionary(input);
        return dictionary.get(word);
    }

    private static Map<String, String> createDictionary(List<Tuple> input) {
        Map<String, String> dictionary = new HashMap<>();
        for(Tuple tuple : input) {
            dictionary.put(tuple.first, tuple.second);
            dictionary.put(tuple.second, tuple.first);
        }
        return dictionary;
    }


    private static List<Tuple> populateDictionary(Scanner input, int n) {
        List<Tuple> dictionary = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split(SPACE);
            dictionary.add(new Tuple(line[0], line[1]));
        }

        return dictionary;
    }

    static class Tuple{
        public final String first;
        public final String second;

        Tuple(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}
