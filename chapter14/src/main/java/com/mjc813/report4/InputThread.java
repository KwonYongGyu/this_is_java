package com.mjc813.report4;

import java.util.Scanner;

public class InputThread extends Thread {
    private DataBox box;

    public InputThread(DataBox box) {
        this.box = box;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("출력할 글자를 입력하고 엔터를 치세요:");

        while (true) {
            String input = sc.next();
            if (input.length() > 0) {
                // 입력받은 첫 글자를 공유 객체에 저장
                box.setSharedChar(input.charAt(0));
            }
        }
    }
}