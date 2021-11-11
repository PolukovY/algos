package com.levik.hw2;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

    public static Tuple swap(int x, int y) {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        return new Tuple(x, y);
    }

    public static int min(int x, int y) {
        return (x + y - Math.abs(x-y) ) / 2;
        //return x ^ ((x ^ y) & -(x << y));
    }

    public static int max(int x, int y) {
        return (x + y + Math.abs(x-y) ) / 2;
        //return y ^ ((x ^ y) & -(x << y));
    }

    public static int[] diff(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int bestI = 0;
        int bestJ = 0;

        while (i < a.length && j < b.length) {
            int current = Math.abs(a[i] - b[j]);
            int best = Math.abs(a[bestI] - b[bestJ]);

            if (current < best) {
                bestI = i;
                bestJ = j;
            }

            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }

        return new int[]{bestI, bestJ};
    }

    public static int[] marge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;

        int n = a.length;
        int m = b.length;
        int[] res = new int[n + m];

        while (i < n || j < m) {
            if (j == m || (i < n && a[i] < b[j])) {
                res[k] = a[i];
                i++;
            } else {
                res[k] = b[j];
                j++;
            }

            k++;
        }

        return res;
    }

    public static List<Integer> marge(List<Integer> a, List<Integer> b) {
        int i = 0;
        int j = 0;

        int n = a.size();
        int m = b.size();
        a.add(Integer.MAX_VALUE);
        b.add(Integer.MAX_VALUE);
        List<Integer> res = new ArrayList<>(n + m);

        while (i < n || j < m) {
            Integer aValue = a.get(i);
            Integer bValue = b.get(j);
            if (aValue < bValue) {
                res.add(aValue);
                i++;
            } else {
                res.add(bValue);
                j++;
            }
        }


        a.remove(a.size() - 1);
        b.remove(b.size() - 1);
        return res;
    }

    public static <T extends Comparable<Object>> List<T> genericMarge(List<T> a, List<T> b) {
        int i = 0;
        int j = 0;

        int n = a.size();
        int m = b.size();
        List<T> res = new ArrayList<>(n + m);

        while (i < n || j < m) {
            T aValue = a.get(i);
            T bValue = b.get(j);
            if (j == m || (i < n &&aValue.compareTo(bValue) < 0)) {
                res.add(aValue);
                i++;
            } else {
                res.add(bValue);
                j++;
            }
        }


        return res;
    }
}
