package com.mjc813.machine;

public class Calculator {
    public long add(int ... items) {
        long sum = 0L;
        for(int i = 0; i<items.length; i++){
            sum += items[i];
        }
        return sum;
    }
}
