package com.mjc813;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    // 필드 선언
    private String name;

    // 생성자 선언
    // @Setter로 대체

    // 메소드 선언
    public void walk() {
        System.out.println("걷습니다.");
    }
}

