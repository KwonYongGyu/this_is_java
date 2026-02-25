package com.mjc813.bookExample;

public class Box<T>{
    public T content;   // 타입 파라미터 T로 사용


    // Box의 내용물이 같은지 비교
    public boolean compare(Box<T> other) {
        boolean result = content.equals(other.content);
        return result;
    }
}
