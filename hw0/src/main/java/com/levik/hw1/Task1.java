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

    //Задовольняє умову time O(sqrt(n)) < O(n * n)
    //i^2 < N
    //i < sqrt(n)
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

    //якщо n <= 10/2 - 1 = 4 - O(1) < O (n * n) - не буде виконуватися жоден із циклів задовольняє умову
    //якщо n >= 10/2 - O(n^4) > O (n * n) -  не задовольняє умову
    //i = 0   1
    //i = 1   2
    //i = 2   3
    //i = 3   4
    //i = 4   5
    //...
    //i = N   N + 1
    public void exampleD(int n) {
        //O(n^2)
        for (int i = 0; i < n * n - 10; i++) {
            //O(n)
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
    // i = 1 dbCall = 0
    // i = 2 dbCall = 1
    // i = 3 dbCall = 2
    // i = 4 dbCall = 2
    // i = 5 dbCall = 3
    // i = 6 dbCall = 3
    // i = 7 dbCall = 3
    // i = 8 dbCall = 3
    // i = 9 dbCall = 3
    // i = 10 dbCall = 4
    // Із ітерації видно що перший цикел O(n), а другий рухється повільно аналогічно log(n)
    //послідовність викликів хмаринки
    //0 + 1 + 2 + 2 + 3 + 3 + 3 + 3 + 4
    //так як у нас крок 2 можемо знайти праву границю < n
    //2^x <= n
    //log 2^x <= log n
    //x <= log n - це ми порахували нижній цикел
    //верхній у нас лінійна складність n
    //Так як він внутрішній ми пермножаємо n * log n
    public void exampleF(int n) {
        //O(n)
        for (int i = 1; i <= n; i++) {
            //log(n)
            int count = 0;
            for (int j = 1; j < i; j *= 2) {
                    dbCall();
                    count++;
            }
            System.out.println("i:= " + i + " count:= " + count);
        }
    }

    // Задоволняє умову O(n*log(n)) > O (n * n)
    //i = 1 dbCall = 10
    //i = 2 dbCall = 5
    //i = 3 dbCall = 4
    //i = 4 dbCall = 3
    //i = 5..9 dbCall = 2
    //i = 10 dbCall = 1
    //
    //Внутрішній цикел залежить від зовнішнього. При збільшенні ітерації внутрішній лічільник виконає менше викликів.
    //Проаналізувавши ітерації викликів нижче можна знайти закономірність log n для внутрішнього лічільника
    //n = 10
    // 10, 5, 4, 3, 2, 1 .. log n
    public void exampleG(int n) {
        //O(n)
        for (int i = 1; i <= n; i++) {
            //O(log(n))
            int count = 0;
            for (int j = 1; j <= n; j += i) {
                dbCall();
                count++;
            }
            System.out.println("i:= " + i + " count:= " + count);
        }
    }

    //Задоволняє умову O(n*log(n)) > O(n * n)
    //n - 10 dbCall = 10
    //n - 5 dbCall = 5
    //n - 2 dbCall = 2
    //n - 1 dbCall = 1
    //n - 0 dbCall = 1
    //n - 0 dbCall = 1
    //n..sqrt(n)
    //10, 5, 2, 1, 1, 1
    //n n/2 n/4 n/8 ... 1 - геометрична прогресія
    //n = 1 * 2^(x-1)
    //log n = log 2^(x-1)
    //log n = (x-1) * log 2
    //x = log n + 1
    //x = log n - це ми розібрали просто нашу рекурсію.
    //Плюс у нас є цикел в середині який залежить від n тому нам потрібно ще перемножити до попереднього
    //Результат n * log n
    public void exampleH(int n) {
        System.out.println("n:= " + n);
        if (n == 0) {
            System.out.println("return n:=" + n);
            return;
        }

        //O(n)
        int count = 0;
        for (int i = 0; i < n; i++) {
            dbCall();
            count++;
        }
        System.out.println("count:= " + count) ;
        //O(log(n/2))
        exampleH(n/2);
        exampleH(n/2);
    }
}
