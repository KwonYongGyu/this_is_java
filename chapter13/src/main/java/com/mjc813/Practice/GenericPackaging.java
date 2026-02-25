package com.mjc813.Practice;

public class GenericPackaging<T> {
    private Object[] list = new Object[10]; // 내부 배열은 Object로 관리
    private int index = -1;

    public void add(T obj) { // 외부에서 들어올 때 이미 T 타입인지 검사함
        if (index >= this.list.length - 1) {
            return;
        }
        this.list[++index] = obj;
    }

    @SuppressWarnings("unchecked")
    public T remove() {
        if (index < 0) {
            return null;
        }
        // 꺼낼 때 자동으로 T 타입으로 변환해서 리턴함
        return (T) this.list[index--];
    }
}