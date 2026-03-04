package com.mjc813.lamda;

public class ClassString implements MyString {
    @Override
    public void procString(String str, int num) {
        // 1번째 기능은 String의 문자갯수랑 int의 정수가 맞는지 체크해서 출력한다.
        int lengthStr = str.length();
        if ( lengthStr == num ) {
            System.out.println("str의 길이와, num 숫자는 같습니다.");
        } else {
            System.out.println("str의 길이와 num 숫자는 다릅니다.");
        }
    }


}
