package com.mjc813;

import lombok.ToString;

@ToString
public class Rabbit extends Animal1 {
    private String myAge;
    private String mySize;

    public Rabbit(String age, String size) {
        this.myAge = age;
        this.mySize = size;
    }

    @Override public String sound() { return "낑낑"; }
    @Override public String age() { return this.myAge; }
    @Override public String size() { return this.mySize; }

    @Override
    public Object eat(Animal1 obj) {
        if (obj instanceof Swan) return "토끼가 " + obj.getClass().getSimpleName() + "을(를) 사냥했습니다!";
        return "토끼는 오직 Swan만 먹는다. " + obj.getClass().getSimpleName() + "은(는) 먹지 못합니다.";
    }

    @Override
    public void breathe() { System.out.println("토끼가 빠르게 숨을 쉽니다."); }
}