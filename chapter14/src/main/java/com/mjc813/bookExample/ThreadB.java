package com.mjc813.bookExample;

public class ThreadB extends Thread {
    private WorkObject workObject;

    public ThreadB(WorkObject workObject) { // 공유 객체를 받음
        setName("ThreadB"); // 스레드 이름 변경
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            workObject.methodB(); // 동기화 메소드 호출
        }
    }
}
