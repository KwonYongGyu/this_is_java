package com.mjc813.report4;

public class OutputThread implements Runnable {
    private DataBox box;

    public OutputThread(DataBox box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            char c = box.getSharedChar();
            if (c != ' ') { // 초기 공백 상태가 아닐 때만 출력
                System.out.println("현재 글자: " + c);
            }
            try {
                Thread.sleep(300); // 300ms 대기
            } catch (InterruptedException e) {
                System.out.println("출력 스레드가 종료되었습니다.");
                return;
            }
        }
    }
}