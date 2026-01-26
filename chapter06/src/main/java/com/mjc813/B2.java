package com.mjc813;

public class B2 {
    public void method(){
    A2 a =new A2();
    a.filed1 = 1;
    a.field2 = 1;
//    a.filed3 = 1;   //x private

    a.method1();
    a.method2();
    a.method3();    //x
    }
}
