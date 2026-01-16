package com.mjc813;

public class chapter03 {
    public void Third01() {
        // - 연산자는 변수값의 부호를 변경할때 사용된다.
        // 부호 변경시 타입이 int로 변화되어서
        // byte b = 100;
        // byte result = -b; 은 컴파일 에러 발생.
        int x = -100;
        x = -x;
        System.out.println("x: " + x);

        byte b = 100;
        int y = -b;
        System.out.println("y: " + y);

        int x1 = 10;
        int y1 = 10;
        int z;

        x1++;
        ++x1;
        System.out.println("x1=" + x1);

        System.out.println("------------------");
        y1--;
        --y1;
        System.out.println("y1=" + y1);

        System.out.println("------------------");
        z = x1++;
        System.out.println("z=" + z);
        System.out.println("x1=" + x1);

        System.out.println("------------------");
        z = ++x1;
        System.out.println("z=" + z);
        System.out.println("x1=" + x1);

        System.out.println("------------------");
        z = ++x1 + y1++;
        System.out.println("z=" + z);
        System.out.println("x1=" + x1);
        System.out.println("y1=" + y1);
    }

    public void Third02() {
        byte v1 = 10;
        byte v2 = 4;
        int v3 = 5;
        long v4 = 10L;

        int result1 = v1 + v2;  // 모든 피연산자는 int 타입으로 자동 변환 후 연산
        System.out.println("result1: " + result1);

        long result2 = v1 + v2 - v4;    // 모든 피연산자는 long 타입으로 자동 변환 후 연산
        System.out.println("result2: " + result2);

        double result3 = (double) v1 / v2;  // double 타입으로 강제 변환 후 연산
        System.out.println("result3: " + result3);

        int result4 = v1 % v2;
        System.out.println("result4: " + result4);
        System.out.println("------------------");


    }

    public void Third03(){
        byte var1 = 125;
        for(int i = 0; i<5; i++){   // { } 를 5번 반복 실행
            var1++; // ++ 연산은 var1의 값을 1 증가시킨다.
            System.out.println("var1: " + var1);
        }

        System.out.println("------------------");

        byte var2 = -125;
        for(int i = 0; i<5; i++){   // { } 를 5번 반복 실행
            var2--; // -- 연산은 var2의 값을 1 감소시킨다.
            System.out.println("var2: " + var2);

        }
    }

    public void Third04(){
        int apple = 1;
        double pieceUnit = 0.1;
        int number = 7;

        double result = apple - number*pieceUnit;
        System.out.println("사과 1개에서 남은 양: " + result);

        int totalPieces = apple * 10;
        int result2 = totalPieces - number;
        System.out.println("10조각에서 남은 조각: " + result2);
        System.out.println("사과 1개에서 남은 양: " + result2/10.0);
    }


}
