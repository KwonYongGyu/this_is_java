package com.mjc813.machine;

public class Calculator {
    public long add(int ... items) {
        long sum = 0L;
        for (int item : items) {
            sum += item;
        }
        return sum;
    }
}
