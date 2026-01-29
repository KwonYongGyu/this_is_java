package com.mjc813;

public class Child1 extends Parent1{
    // 확인문제 6번 super를 사용하지 않아서
//    public int studentNo;
//    public Child1(String name, int studentNo){
//        super(name);
//        this.name = name;
//        this.studentNo = studentNo;
//    }
    // 문제 7
    public String name;
    public Child1(){
        this("홍길동");
        System.out.println("Child() call");
    }
    public Child1(String name){
        this.name = name;
    System.out.println("Child(String name) call");

    }
}
