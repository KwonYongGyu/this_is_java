package com.mjc813;

public class Taxi implements Vehicle{
    // 추상 매소드 재정의
    @Override
    public void run(){
        System.out.println("택시가 달립니다.");
    }
}
