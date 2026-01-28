package com.mjc813;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Animal {
    // @Setter 사용을 위해 필드 추가
    private String kind;
    // 메소드 선언
    public void breath(){
        System.out.println("숨을 쉽니다.");
    }

    // 추상 메소드 선언
    public abstract void sound();
}
