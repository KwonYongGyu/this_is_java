package com.mjc813;

public class A1 {
    A1 a1 = new A1(true);
    A1 a2 = new A1(1);
    A1 a3 = new A1("문자열");

    // public 접근 제한 생성자 선언
    public A1(boolean b){

    }

    //default 접근 제한 생성자 선언
    A1(int b){

    }

    // private 접근 제한 생성자 선언
    private A1(String s){

    }
}
