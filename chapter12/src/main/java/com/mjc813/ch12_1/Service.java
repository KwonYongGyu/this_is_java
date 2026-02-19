package com.mjc813.ch12_1;

public class Service {
    @PrintAnnotation    // PrintAnnotation 적용
    public void method1(){
        System.out.println("실행 내용1");
    }

    @PrintAnnotation("*") // PrintAnnotation 적용
    public void method2(){
        System.out.println("실행 내용2");
    }

    @PrintAnnotation(value="#", number=20)
    public void method3(){
        System.out.println("실행 내용");
    }

}
