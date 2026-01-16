package com.mjc813;

public class chapter03 {
    public void Third01(){
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

        int x = 10;
        int y = 10;
        int z;

        x++;
        ++x;
        System.out.println("x=" + x);

        System.out.println("------------------");
        y--;
        --y;
        System.out.println("y=" + y);

        System.out.println("------------------");
        z = x++;
        System.out.println("z=" + z);
        System.out.println("x=" + x);

        System.out.println("------------------");
        z = ++x;
        System.out.println("z=" + z);
        System.out.println("x=" + x);
    }

}
