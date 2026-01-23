package com.mjc813;

public class Car4 {
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    // p.230 메소드 오버로딩
    Car4(String model){
    // 생성자 호출
        this(model, "은색", 250);
    }
    Car4(String model, String color){
        // 생성자 호출
        this(model,  color, 250);
    }
    Car4(String model, String color, int maxSpeed){
        // 생성자 호출
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;

    }

}
