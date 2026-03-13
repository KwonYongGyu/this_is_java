package com.mjc813.bookExample;

public class PrintThread2 {
    public void run() {
        try {
            while(true) {
                System.out.println("실행 중");
                Thread.sleep(1); // 일시정지를 0.001초동안 만듬
            }
        } catch (InterruptedException e) {

        }
        System.out.println("리소스 정리");
        System.out.println("실행 종료");
    }
}
