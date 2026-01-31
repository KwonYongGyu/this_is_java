package com.mjc813;

public class Bus implements Vehicle{
    // 추상 매소드 재정의
    @Override
    public void run(){
        System.out.println("버스가 달립니다.");
    }

    // 추가 매소드
    public void checkFare(){
        System.out.println("승차요금을 체크합니다.");
    }
}
