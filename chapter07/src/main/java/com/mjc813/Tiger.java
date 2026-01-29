package com.mjc813;

import lombok.ToString;

@ToString
public class Tiger extends Animal1 {
    private String myAge;
    private String mySize;

    public Tiger(String age, String size) {
        this.myAge = age;
        this.mySize = size;
    }

    @Override public String sound() { return "어흥"; }
    @Override public String age() { return this.myAge; }
    @Override public String size() { return this.mySize; }

    @Override
    public Object eat(Animal1 obj) {
        if (obj instanceof Rabbit) return "호랑이가 토끼를 사냥했습니다.";
        return "호랑이는 " + obj.getClass().getSimpleName() + "는 먹지 않습니다.";
    }

    @Override
    public void breathe() { System.out.println("호랑이가 거칠게 숨을 쉽니다."); }
}