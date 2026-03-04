package com.mjc813.lamda;

public class ClassString2 implements MyString {
    @Override
    public void procString(String str, int num) {
    // 2번째 기능은 String의 문자열을 int의 정수만큼 반복해서 출력한다.
        for(int i = 0; i< num; i++ ) {
            System.out.println(str);
        }
        System.out.println();
    }
}
