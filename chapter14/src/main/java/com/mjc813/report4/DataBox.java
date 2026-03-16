package com.mjc813.report4;

public class DataBox {
    // 여러 스레드가 동시에 접근하므로 최신 값을 보장하기 위해 volatile 사용
    private volatile char sharedChar = ' ';

    public char getSharedChar() {
        return sharedChar;
    }

    public void setSharedChar(char sharedChar) {
        this.sharedChar = sharedChar;
    }
}