package com.mjc813.chapter11exam;

public class InsufficientException extends RuntimeException {   // 일반 예외로 선언
    public InsufficientException() {

    }

    public InsufficientException(String message) {
        super(message);
    }// 두개의 생성자 선언
}
