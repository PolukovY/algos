package com.levik.hw1;

public class Task1 {

    private long dbCallCount = 0L;

    private void dbCall() {
        dbCallCount++;
    }

    public void resetDbCallCount() {
        dbCallCount = 0L;
    }

    public long getDbCallCount() {
        return dbCallCount;
    }

    public void example1(int n) {
        for (int i = 0; i < n + 10; i++) {
            dbCall();
        }
    }

    // Задовольняє умову так як крок у нас i /=2. І у нас буде 3 виклики.
    public void example2(int n) {
        for (int i = n; i > 1; i /= 2) {
            dbCall();
        }
    }

    // Задовольняє умову буде меньше половини n.
    // 0 * 0 < 10 true
    // 1 * 1 < 10 true
    // 2 * 2 < 10 true
    // 3 * 3 < 10 true
    public void example3(int n) {
        for (int i = 0; i * i < n; i++) {
            dbCall();
        }
    }

    // Не задоволняє умову так як для кожного ми виконаємо 356 викликів і це буде більше за нашу умову.
    public void example4(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 356; j++) {
                dbCall();
            }
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }

    // Не задоволняє умову. Тому що у нас є другий цикел який збільше нашу калькуляцію.
    // i = 0, j <= 0 - 1 call
    // i = 1, j <= 1 - 2 call
    // i = 2, j <= 2 - 3 call
    // i = 3, j <= 3 - 4 call
    // Із прикладу ми бачимо що для одної ітерації у нас починає збільшуватися в рази виклики, що перевишує наш ліміт.
    public void example5(int n) {
        for (int i = 0; i < n * n - 10; i++) {
            for (int j = 0; j <= i; j++) {
                dbCall();
            }
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }

    // Не задоволняє умову. Тому що у нас є другий і третій цикел який збільше нашу калькуляцію.
    //i:= 1 dbCall:= 1
    //i:= 2 dbCall:= 4
    //i:= 3 dbCall:= 10
    //i:= 4 dbCall:= 20
    //i:= 5 dbCall:= 35
    //i:= 6 dbCall:= 56
    //i:= 7 dbCall:= 84
    //i:= 8 dbCall:= 120
    //i:= 9 dbCall:= 165
    //i:= 10 dbCall:= 220
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

    // Задоволняє нашу умову, так як внутрішній цикел рухаєтся з кроком j *=2
    public void example7(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j *= 2) {
                    dbCall();
                }
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }

    // Задоволняє нашу умову, так як внутрішній цикел рухаєтся з кроком j *=i. Аналогічно перередньому але там крок був константа.
    // А тут він динамічний і збільшується, що тим самим виконує менше викликів до бд.
    public void example8(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j += i) {
                dbCall();
            }
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
    }

    // Задоволняє нашу умову, так як в першому циклі ми робимо n колів.
    // А також зменшуємо в 2 рази кожний рукерсивний виклик який виконує цикл з меншою кількістю ітерації.
    public void example9(int n) {
        System.out.println("example9 n:= " + n);
        if (n == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            dbCall();
            System.out.println("i:= " + i + " dbCall:= " + getDbCallCount()) ;
        }
        example9(n/2);
        example9(n/2);
    }
}
