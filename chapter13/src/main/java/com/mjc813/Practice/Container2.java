package com.mjc813.Practice;

public class Container2 <K, V> {
    // 필드
    private K key;
    private V value;

    public void set(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return this.key;
    }
    public V getValue() {
        return this.value;
    }
}
