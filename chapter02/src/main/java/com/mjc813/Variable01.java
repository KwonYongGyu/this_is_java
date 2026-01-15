package com.mjc813;

public class Variable01 {
    public void howToUseVariable() {

        int value = 30;
        int result = value + 10;
        System.out.println(result);

        int hour = 3;
        int minute = 5;
        System.out.println(hour + "시간" + minute + "분");
        int totalMinute = (hour * 60) + minute;
        System.out.println("총 " + totalMinute + "분");

        int x = 3;
        int y = 5;
        System.out.println("x:" + x + ", y:" + y);

        int temp = x;
        x = y;
        y = temp;

        System.out.println("x:" + x + ", y:" + y);
    }

}
