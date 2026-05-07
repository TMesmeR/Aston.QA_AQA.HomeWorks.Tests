package org.example;

public class NumberComparator {
    public static String compare(int a, int b) {
        if (a > b) {
            return a + " больше " + b;
        } else if (a < b) {
            return a + " меньше " + b;
        } else {
            return a + " равно " + b;
        }
    }

    public static int findMax(int a, int b) {
        return Math.max(a, b);
    }

    public static int findMin(int a, int b) {
        return Math.min(a, b);
    }
}
