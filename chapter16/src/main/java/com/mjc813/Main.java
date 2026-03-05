package com.mjc813;

import com.mjc813.lamda.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        NormalUseInterface nui = new NormalUseInterface();
//        nui.doSome();
//
//        LamdaUseInterface lui = new LamdaUseInterface();
//        lui.doSome((str, n) -> {
//            System.out.println(str.length() == n ? "같다" : "다르다");
//        }, "abc", 3);
//
//        lui.doSome((sss, i) -> {
//            for ( int m = 0; m < i; m++ ) {
//                System.out.println(sss);
//            }
//            System.out.println();
//        }, "def", 3);
//
//
//        AlreayHasMethod ahm = new AlreayHasMethod();
//        ahm.printStringInt("aaa", 1);
//
//        lui.doSome( ahm::printStringInt, "abcdefg", 4); // 기존의 메소드를 실행하라는 의미
//
//        lui.doSome(ConstructorClass::new, "lmnopq", 2); // 생성자를 실행하라는 의미
//        ConstructorClass cc = new ConstructorClass("lmnop", 2);

        Chapter16 ch16 = new Chapter16();
//        ch16.LamdaExample1();
//        ch16.LamdaExample2();
//        ch16.ButtonExample();
//        ch16.LamdaExample3();
//        ch16.LamdaExample4();
        ch16.MethodReferenceExample();
//        ch16.MethodReferenceExample2();
//        ch16.ConstructorReferenceExample();


    }

}