package com.mjc813;

public class BooleanType {
    boolean stop = true;
    int x = 10;

    public void useBoolean(){
        if(stop) {
            System.out.println("중지합니다.");
        }else{
            System.out.println("시작합니다.");
        }
        boolean result1 =(x == 20);
        boolean result2 = (x != 20);
        System.out.println("result1: "+ result1);
        System.out.println("result2: "+ result2);
    }
}
