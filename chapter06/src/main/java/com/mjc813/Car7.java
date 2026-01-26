package com.mjc813;

public class Car7 {
    int speed;

    // 인스턴스 메소드 선언
    void run(){
        System.out.println(speed + "으로 달립니다.");
    }
    static void simulate(){
        //객체 생성
        Car7 myCar = new Car7();
        // 인스턴스 맴버 사용
        myCar.speed = 200;
        myCar.run();
    }

}
