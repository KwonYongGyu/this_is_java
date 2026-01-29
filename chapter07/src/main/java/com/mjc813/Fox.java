package com.mjc813;

import lombok.ToString;

@ToString
public class Fox extends Animal1 {
    private String myAge;
    private String mySize;

    public Fox(String age, String size) {
        this.myAge = age;
        this.mySize = size;
    }

    @Override public String sound() { return "캉캉"; }
    @Override public String age() { return this.myAge; }
    @Override public String size() { return this.mySize; }

    @Override
    public Object eat(Animal1 obj) {
        if (obj instanceof Swan || obj instanceof Rabbit) {
            return "여우가 " + obj.getClass().getSimpleName() + "를 사냥했습니다.";
        }
        return "여우는 " + obj.getClass().getSimpleName() + "를 먹지 않습니다.";
    }

    @Override
    public void breathe() { System.out.println("여우가 조용히 숨을 쉽니다."); }
}