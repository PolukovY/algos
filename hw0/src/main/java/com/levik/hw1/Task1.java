package com.levik.hw1;

public class Task1 {

    private long dbCallCount = 0L;

    private void dbCall() {
        dbCallCount++;
    }

    public long getDbCallCount() {
        return dbCallCount;
    }

    //Задовольняє умову // O(log(n)) < n * n
    public void exampleA(int n) {
        for (int i = n; i > 1; i /= 2) {
            dbCall();
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }

    //Задовольняє умову time O(log(n)) < O(n * n)
    public void exampleB(int n) {
        for (int i = 0; i * i < n; i++) {
            dbCall();
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }

    //n - розмірність першого циклу, m - розмірність другого циклу
    //Задоволняє умову m = 356 m < n.
    //Не задовольняє умову якщо n < m
    // n * m < n * n
    public void exampleC(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 356; j++) {
                dbCall();
            }
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }

    //Не задовольняє умову time O(n^3) > O (n * n) ???
    public void exampleD(int n) {
        for (int i = 0; i < n * n - 10; i++) {
            for (int j = 0; j <= i; j++) {
                dbCall();
            }
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }

    // Не задовольняє умову time O(n^3) > O (n * n) ???
    public void exampleE(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                for (int k = 1; k <= j; k++) {
                    dbCall();
                }
            }
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }

    // Задоволняє умову O(n * log(n)) < O (n * n)
    public void exampleF(int n) {
        //O(n)
        for (int i = 1; i <= n; i++) {
            //log(n)
            for (int j = 1; j < i; j *= 2) {
                    dbCall();
            }
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }

    // Задоволняє умову O(n^2) > O (n * n)
    public void exampleG(int n) {
        //O(n)
        for (int i = 1; i <= n; i++) {
            //O(n)
            for (int j = 1; j <= n; j += i) {
                dbCall();
            }
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount());
        }
    }

    //Задоволняє умову O(n) > O(n * n)
    public void exampleH(int n) {
        System.out.println("example9 n:= " + n);
        if (n == 0) {
            return;
        }

        //O(n)
        for (int i = 0; i < n; i++) {
            dbCall();
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
        //O(n/2 - stack space + n - iteration)
        exampleH(n/2);
        exampleH(n/2);
    }
}
