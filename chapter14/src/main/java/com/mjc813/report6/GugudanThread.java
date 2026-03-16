package com.mjc813.report6;

public class GugudanThread extends Thread {
    private int dan;

    public GugudanThread(int dan) {
        this.dan = dan;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(dan + " * " + i + " = " + (dan * i));
            try {
                // 1000ms(1초) 간격으로 출력
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // 스레드가 중단될 경우 루프 종료
                return;
            }
        }
        // 9까지 출력하면 스레드는 자동으로 종료됨
    }
}