package com.mjc813;

public non-sealed class Manager extends Person1{
    public Manager(String name) {
        super(name);
    }
    @Override
    public void work(){
        System.out.println("생산 관리를 합니다.");
    }
}
