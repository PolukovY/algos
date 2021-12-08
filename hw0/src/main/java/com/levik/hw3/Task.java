package com.levik.hw3;

import java.util.*;
import java.util.function.Function;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.toMap;

public class Task {

    static class User {
        private final Integer id;
        private final String name;
        private final int age;

        public static User of(Integer id, String name, int age) {
            return new User(id, name, age);
        }

        private User(Integer id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<User> users = getUsers();
        System.out.println(Arrays.toString(users.toArray()));

        Map<String, User> items = users.stream()
                .sorted(comparing(User::getId).thenComparing(User::getName))
                .collect(toMap(User::getName, Function.identity(), (a1, a2) -> a1));

        items.keySet().forEach(key -> System.out.println(key + " " + items.get(key)));
    }

    private static List<User> getUsers() {
        return Arrays.asList(
                User.of(1, "Yevgen", 23),
                User.of(2, "Dima", 20),
                User.of(-2, "Dima", 30)
        );
    }
}
