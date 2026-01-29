package com.mjc813;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@ToString
public abstract class Animal1 {
    public abstract String sound();  // 울음소리

    public abstract String age();       // 나이

    public abstract String size();   // 크기

    public abstract Object eat(Animal1 obj); // 먹이 행동

    public abstract void breathe();// 호흡

}