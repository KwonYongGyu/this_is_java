package com.mjc813;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car1 {
    // 필드 선언
    private Tire tire;
    // 메소드 선언
    public void run(){
        // tire 필드에 대입된 객체의 roll() 메소드 호출
        tire.roll();
    }

}
