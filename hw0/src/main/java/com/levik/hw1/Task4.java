package com.levik.hw1;

public class Task4 {
    /*
    a. def run(int n) {
        if (n <= 0) return;
        a[k++] = n;
        go(n - 1);
        a[k++] = n;
    }
------
    b. def projection(int n, int[] x, int[] y, double[] z, double angle) {
        for (int i = 0; i < n; i++)
            z[i] = x[i] * cos(angle) + y[i] * sin(angle);
    }
------
    c.
    int n, p[n], a[n], b[n]; // p - перестановка
for (int k = 0; k < n; k++) {
        int cnt = 0;
        for (int i = k; i < n - k; i++)
            if (a[p[i]] >= b[k])
                cnt ++;
        print(cnt);
    }
    */

    public static void solutionC() {
        int n = 10;
        int[] p = new int[n];
        int[] a = new int[n];
        int[] b = new int[n];
        int cnt = 0;

        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            tmp[i] = a[p[i]];
        }

        for (int k = 0; k < n; k++) {
            int value = b[k];
            for (int i = k; i < n - k; i++) {
                int tmpValue = tmp[i];
                if (tmpValue >= value) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
