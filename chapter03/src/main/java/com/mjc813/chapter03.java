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

    public int equationFirst(int a, int b){
//        int x = 0;
        //ax + b = 0, 2x+8=0 x = -4, 5x -30 = 0, x=??
        // x를 구한다.
//        x = -b / a;
        return -b / a;
    }

    public void CompareOperatorExample(){
        int num1 = 10;
        int num2 = 10;
        boolean result1 = (num1 == num2);
        boolean result2 = (num1 != num2);
        boolean result3 = (num1 <= num2);
        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
        System.out.println("result3: " + result3);

        char char1 = 'A';
        char char2 = 'B';
        boolean result4 = (char1 < char2);  // ASCII 코드 값으로 65 < 66
        System.out.println("result4: "+ result4);

        int num3 = 1;
        double num4 = 1.0;
        boolean result5 = (num3 == num4);
        System.out.println("result5: " + result5);

        float num5 = 0.1f;
        double num6 = .1;
        boolean result6 = (num5 == num6);
        boolean result7 = (num5 ==(float)num6);
        System.out.println("result6: " + result6);
        System.out.println("result7: " + result7);

        String str1 = "자바";
        String str2 = "Java";
        boolean result8 = (str1.equals(str2));
        boolean result9 = (! str1.equals(str2));
        System.out.println("result8: " + result8);
        System.out.println("result9: " + result9);
    }
    public void logicalOperatorExample(){
        int charCode = 'A';
        // int charCode = 'a';
        // int charCode = '5';

        if( (65<=charCode) & (charCode<=90) ){
            System.out.println("대문자이군요.");
        }

        if( (97<=charCode) && (charCode<=122) ){
            System.out.println("소문자이군요.");
        }

        if( (48<=charCode) && (charCode<=57) ){
            System.out.println("0~9 숫자이군요.");
        }

        int value = 6;
        // int value = 7;

        if( (value%2==0) | (value%3==0) ){
            System.out.println("2 또는 3의 배수인군요.");
        }

        boolean result = (value%2==0) || (value%3==0);
        if( !result ){
            System.out.println("2 또는 3의 배수가 아니군요.");
        }
    }

    public void BitLogicExample(){
        System.out.println("45 & 25 = " + (45 & 25));
        System.out.println("45 | 25 = " + (45 | 25));
        System.out.println("45 ^ 25 = " + (45 ^ 25));
        System.out.println("~45 = " + (~45));   // 1의 보수
        System.out.println("--------------------");

        byte receiveData = -120;

        // 방법1 : 비트 논리곱 연산으로  Unsigned 정수 얻기
        int unsignedInt1 = receiveData & 255;
        System.out.println(unsignedInt1);

        // 방법2 : 자바 API를 이용해서 Unsigned 정수 얻기
        int unsignedInt2 = Byte.toUnsignedInt(receiveData);
        System.out.println(unsignedInt2);

        int test = 136;
        byte btest = (byte)test;
        System.out.println(btest);

    }

    public void BitShiftExample1(){
        int num1 = 1;
        int result1 = num1 <<3;
        int result2 = num1 * (int) Math.pow(2, 3);
        // Math.pow(2, 3)은 2^3을 연산하고, double 값을 산출한다.
        // int값으로 얻고 싶다면 int로 캐스팅해야한다.
        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);

        int num2 = -8;
        int result3 = num2 >> 3;
        int result4 = num2 / (int) Math.pow(2, 3);
        System.out.println("result3: " + result3);
        System.out.println("result4: " + result4);
    }
    public void BitShiftExample2(){
        int value = 772;    //[0000000] [00000000] [00000011] [0000100]

        // 우측으로 3byte(24bit) 이동하고 끝 1바이트만 읽음: [00000000]
        byte byte1 = (byte) (value >>> 24);
        int int1 = byte1 & 255;
        System.out.println("첫 번째 바이트 부호 없는 값: " + int1);

        // 우측으로 2byte(16bit) 이동하고 끝 1바이트만 읽음 :[00000000]
        byte byte2 = (byte)     (value >>> 16);
        int int2 = Byte.toUnsignedInt((byte2));
        System.out.println("두 번째 바이트 부호 없는 값: " + int2);

        // 우측으로 1byte(8bit) 이동하고 끝 1바이트만 읽음: [00000011]
        byte byte3=(byte)       (value >>> 8);
        int int3 = byte3 & 255;
        System.out.println("세 번째 바이트 부호 없는 값: " + int3);

        // 끝 1바이트만 읽음: [00000100]
        byte byte4 = (byte) value;
        int int4 = Byte.toUnsignedInt(byte4);
        System.out.println("네 번째 바이트 부호 없는 값: " + int4);
    }

    public void AssignmentOperatorExample(){
        int result = 0;
        result +=10;
        System.out.println("result: " + result);
        result -=5;
        System.out.println("result: " + result);
        result *=3;
        System.out.println("result: " + result);
        result /=5;
        System.out.println("result: " + result);
        result %= 3;
        System.out.println("result: " + result);
    }

    public void ConditionalOperationExample(){
        int score =85;
        char grade = (score > 90) ? 'A' : ( (score >80) ? 'B' : 'C' );
        System.out.println(score + "점은" + grade + "등급입니다.");
    }
    public void chapter03Test(){
        // 문제 1
        int x = 10;
        int y = 20;
        int z = (++x) + (y--);  // 후위 연사자는 소괄호 안에 있어도 계산 우선순위는 올라가지 않는다.
        System.out.println(z);
        // 문제 2
        int score = 85;
        String result = (!(score>90))? "가" : "나";
        System.out.println(result);
        // 문제 3
        int pencils = 534;
        int students = 30;
        // 학생 한 명이 가지는 연필 수
        int pencilsPerStudents = (pencils/students);
        System.out.println(pencilsPerStudents);
        // 남은 연필 수
        int pencilsLeft = (pencils % students);
        System.out.println(pencilsLeft);
        // 문제 4
        int value = 356;
        System.out.println(value/100*100);
        // 356을 100으로 나누어서 3으로 바꾼뒤 다시 100을 곱해서 300으로  만듬
        // 문제 5
        int lengthTop = 5;
        int lengthBottom = 10;
        int height = 7;
        double area1 = ((lengthTop + lengthBottom) * height / 2.0);
        double area2 = ((lengthTop + lengthBottom) * height * 1.0/2 );
        double area3 = ((double)(lengthTop + lengthBottom)*height/2);
        double area4 = ((double)((lengthTop+lengthBottom)*height/2));
        System.out.println(area1);
        System.out.println(area2);
        System.out.println(area3);
        System.out.println(area4);
        // 문제 6
        int x1 = 10;
        int y1 = 5;
        System.out.println( (x1>7) && (y1<=5)   );
        System.out.println( (x1%3 == 2) || (y1%2 != 1)  );
        // 문제 7
        double x2 = 5.0;
        double y2 = 0.0;
        double z2 = 5 % y2;
        if(Double.isNaN(z2)){
            System.out.println("0.0으로 나눌 수 없습니다.");
        } else{
            double result1 = z + 10;
            System.out.println("결과: " + result1);
        }

    }

}
