package com.mjc813;

public class AutoTranslate {
    public void useAuto(){
    // 여기서부턴 자동 타입변환입니다.
        byte byteValue = 10;
        int intValue = byteValue;
        System.out.println("intValue: " + intValue);

        intValue = '가';
        System.out.println("가의 유니코드: " + intValue);

        intValue = 50;
        long longValue=intValue;
        System.out.println("longValue: " + longValue);

        longValue = 100;
        float floatValue = longValue;
        System.out.println("floatValue: "+floatValue);

        floatValue=100.5f;
        double doubleValue = floatValue;
        System.out.println("doubleValue: " + doubleValue);

        // ---------------------------------------------------------------
        // 여기서 부터 강제 타입 변환입니다.
        int var1 = 10;
        byte var2=(byte)var1;
        System.out.println(var2);   // 강제 타입 변환 후에 1이 그대로 유지

        long var3 = 300;
        int var4 = (int)var3;
        System.out.println(var4);   // 강제 타입 변환 후에 300이 그대로 유지

        int var5 = 65;
        char var6 = (char)var5;
        System.out.println(var6);   // 'A'가 출력

        double var7 = 3.14;
        int var8 = (int) var7;
        System.out.println(var8);   // 3이 출력

        // ---------------------------------------------------------------
        // 정수계산해서 0.0이 나오는걸 실수형으로 타입변환을 통해 제대로 값이 출력되는지 확인합니다.
        int x=1;
        int y=2;
        double result = x / y;  // 일부로 x,y를 double선언을 하지 않아서 0.0이 출력되게 만듬
        System.out.println(result); // 0.5가 출력되는지 확인
        // 자바에서 정수 연산은 항상 정수값만 되기 때문에
        // x나 y중 둘중 하나라도 실수형으로 변환되면 0.5가 출력되게 된다.

        double result1 = (double) x/y;
        System.out.println(result1); // 방법1

        double result2 = x / (double) y;
        System.out.println(result2);    // 방법2

        double result3 = (double) x/(double) y;
        System.out.println(result3);    // 방법3
    }
}
