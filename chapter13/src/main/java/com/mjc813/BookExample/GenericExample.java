package com.mjc813.bookExample;

public class GenericExample {
    public static <T extends Number> boolean compare(T t1, T t2) {
        // T의 타입을 출력
        System.out.println("compare(" + t1.getClass().getSimpleName() + ", " +
                t2.getClass().getSimpleName() + ")");

        // Number의 메소드 사용
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();

        return (v1 == v2);
    }
}
