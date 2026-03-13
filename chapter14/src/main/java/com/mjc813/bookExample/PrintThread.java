package com.mjc813.bookExample;

public class PrintThread extends Thread {
    private boolean stop;

    // 외붕서 stop 필드값을 변경할 수 있도록 Setter 선언
    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
        while(!stop) {
            System.out.println("실행 중"); // stop 필드값에 따라 반복 여부 결정
        }
        System.out.println("리소스 정리"); // 리소스 정리
        System.out.println("실행 종료");
    }
}
