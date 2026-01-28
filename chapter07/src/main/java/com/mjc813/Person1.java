package com.mjc813;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public sealed class Person1 permits Employee, Manager{
    // 필드
    private String name;

    // 메소드
    public void work(){
        System.out.println("하는 일이 결정되지 않았습니다.");
    }
}
