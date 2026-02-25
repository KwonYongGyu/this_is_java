package com.mjc813.Practice;

public class Container <T> {
    // T 타입의 데이터를 저장할 멤버 변수
    private T data;

    // 데이터를 저장하는 메소드(매개변수 타입이 T)
    public void set(T data) {
        this.data = data;
    }

    // 데이터를 가져오는 메소드(리턴 타입이 T)
    public T get() {
        return this.data;
    }
}
