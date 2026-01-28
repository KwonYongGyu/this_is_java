package com.mjc813;

public class Dog extends Animal{
    public Dog(){
        super("개"); // 부모 생성자 호출하여 kind 설정
    }
    @Override
    public void sound(){
        System.out.println("멍멍");
    }
}
