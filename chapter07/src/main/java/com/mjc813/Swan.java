package com.mjc813;

import lombok.ToString;

@ToString
public class Swan extends Animal1 {
    private String myAge;
    private String mySize;

    public Swan(String age, String size) {
        this.myAge = age;
        this.mySize = size;
    }

    @Override public String sound() { return "끼룩끼룩"; }
    @Override public String age() { return this.myAge; }
    @Override public String size() { return this.mySize; }

    @Override
    public Object eat(Animal1 obj) { return "Swan은 다른 동물을 먹지 않습니다."; }

    @Override
    public void breathe() { System.out.println("Swan이 수면 위에서 호흡합니다."); }
}