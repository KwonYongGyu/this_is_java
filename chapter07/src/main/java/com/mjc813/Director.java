package com.mjc813;

public class Director extends Manager{
    public Director(String name) {
        super(name);
    }
    @Override
    public void work(){
        System.out.println("제품을 기획합니다.");
    }
}
