package com.mjc813;

public class TranslateType {
    public void useTranslate() {
        byte result1 = 10 + 20; // 컴파일 단계에서 연산
        System.out.println("result1: " + result1);

        byte v1 = 10;
        byte v2 = 20;
        int result2 = v1 + v2;
        System.out.println("result2: " + result2);

        byte v3 = 10;
        int v4 = 100;
        long v5 = 1000L;
        long result3 = v3 + v4 + v5;    // long 타입으로 변환 후 연산
        System.out.println("result3: " + result3);

        char v6 = 'A';
        char v7 = 1;
        int result4 = v6 + v7; // int 타입으로 변환 후 연산
        System.out.println("result4: " + result4);
        System.out.println("result4: " + (char) result4);

        int v8 = 10;
        int result5 = v8 / 4; // 정수 연산의 결과는 정수
        System.out.println("result5: " + result5);

        int v9 = 10;
        double result6 = v9 / 4.0;    // double 타입으로 변환 후 연산
        System.out.println("result6: " + result6);

        int v10 = 1;
        int v11 = 2;
        double result7 = (double) v10 / v11;    // double 타입으로 변환 후 연산
        System.out.println("result7: " + result7);

        // 숫자 연산
        int result8 = 10 + 2 + 8;
        System.out.println("result8: " + result8);

        // 결합 연산
        String result9 = 10 + 2 + "8";
        System.out.println("result9: " + result9);

        String result10 = 10 + "2" + 8;
        System.out.println("result10: " + result10);

        String result11 = "10" + 2 + 8;
        System.out.println("result11: " + result11);

        String result12 = "10" + (2 + 8);
        System.out.println("result12: " + result12);

        //2-10의 예제 시작
        int value1 = Integer.parseInt("10");
        double value2 = Double.parseDouble("3.14");
        boolean value3 = Boolean.parseBoolean("true");

        System.out.println("value1: " + value1);
        System.out.println("value2: " + value2);
        System.out.println("value3: " + value3);

        String str1 = String.valueOf(10);
        String str2 = String.valueOf(3.14);
        String str3 = String.valueOf(true);

        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
    }
}
