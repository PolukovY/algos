package com.levik.hw1;

public class Task1 {

    private long dbCallCount = 0L;

    private void dbCall() {
        dbCallCount++;
    }

    public long getDbCallCount() {
        return dbCallCount;
    }

    //Задовольняє умову time O(n) < O (n * n)
    public void example1(int n) {
        for (int i = 0; i < n + 10; i++) {
            dbCall();
        }
    }

    //Задовольняє умову time O(log(n)) < O(n * n)
    public void example2(int n) {
        for (int i = n; i > 1; i /= 2) {
            dbCall();
        }
    }

    //Задовольняє умову time O(log(n)) < O(n * n)
    public void example3(int n) {
        for (int i = 0; i * i < n; i++) {
            dbCall();
        }
    }

    //Не задовольняє умову time O(356 * n) > O(n * n)
    public void example4(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 356; j++) {
                dbCall();
            }
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }



    //Не задовольняє умову time O(n^n^n) > O (n * n) ???
    public void example5(int n) {
        for (int i = 0; i < n * n - 10; i++) {
            for (int j = 0; j <= i; j++) {
                dbCall();
            }
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }

    // Не задовольняє умову time O(n^n^n) > O (n * n) ???
    public void example6(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                for (int k = 1; k <= j; k++) {
                    dbCall();
                }
            }
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }

    // Задоволняє умову O(n * n/2*j) < O (n * n) ???
    public void example7(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j *= 2) {
                    dbCall();
            }
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }

    // Задоволняє умову O(n * n/i) > O (n * n) ???
    public void example8(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j += i) {
                dbCall();
            }
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }

    //Задоволняє умову O(n * log(n/2)) > O(n *n)
    public void example9(int n) {
        System.out.println("example9 n:= " + n);
        if (n == 0) {
            return;
        }

        //O(n)
        for (int i = 0; i < n; i++) {
            dbCall();
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
        //O(log(n/2))
        example9(n/2);
        //O(log(n/2))
        example9(n/2);
    }
}
