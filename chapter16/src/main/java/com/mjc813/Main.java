package com.mjc813;

import com.mjc813.lamda.LamdaUseInterface;
import com.mjc813.lamda.NormalUseInterface;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NormalUseInterface nui = new NormalUseInterface();
        nui.doSome();

        LamdaUseInterface lui = new LamdaUseInterface();
        lui.doSome((str, n) -> {
            System.out.println(str.length() == n ? "같다" : "다르다");
        }, "abc", 3);

        lui.doSome((sss, i) -> {
            for ( int m = 0; m < i; m++ ) {
                System.out.println(sss);
            }
            System.out.println();
        }, "def", 3);
    }
}