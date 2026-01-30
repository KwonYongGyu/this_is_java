package com.mjc813;

public class Example {
    public static void action(A a){
        a.method1();
        if(a instanceof C){
            C c = (C) a; // C 타입으로 강제 타입 변환
            c.method2();
        }
    }
}
