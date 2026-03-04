package com.mjc813.lamda;

public class NormalUseInterface {
    public void doSome() {
        MyString ms1 = new ClassString();
        ms1.procString("abc", 3);
        MyString ms2 = new ClassString2();
        ms2.procString("abc", 3);
    }
}
