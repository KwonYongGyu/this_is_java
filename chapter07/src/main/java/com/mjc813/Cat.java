package com.mjc813;

public class Cat extends Animal{
    public Cat() {
        super("고양이");
    }
    // 추상 매소드 재정의
    @Override
    public void sound(){
        System.out.println("야옹");
    }
}
