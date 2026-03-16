package com.mjc813.report4;

public class Report4Main {
    public static void main(String[] args) {
        // 1. 두 스레드가 공유할 데이터 객체 생성
        DataBox box = new DataBox();

        // 2. 출력 스레드 생성 (Runnable 구현체이므로 Thread 객체로 감쌈)
        Thread output = new Thread(new OutputThread(box));

        // 3. 입력 스레드 생성 (Thread 상속 객체)
        InputThread input = new InputThread(box);

        // 4. 두 스레드 동시 실행
        output.start();
        input.start();
    }
}