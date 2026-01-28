package com.mjc813;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public abstract class Phone1 {
    // 필드 선언
    private String owner;

    // 생성자 선언

    // 메소드 선언
    void turnOn(){
        System.out.println("폰 전원을 켭니다.");
    }
    void turnOff(){
        System.out.println("폰 전월을 끕니다.");
    }
}
