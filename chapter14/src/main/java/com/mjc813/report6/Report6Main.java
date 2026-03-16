package com.mjc813.report6;

import java.util.Scanner;

public class Report6Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("출력할 구구단 숫자(1-9)를 입력하세요 (종료: 0):");

        while (true) {
            // 사용자의 입력을 기다림 (Blocking)
            int inputDan = sc.nextInt();

            // 종료 조건
            if (inputDan == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 새로운 숫자가 입력될 때마다 새로운 스레드를 생성해서 실행!
            GugudanThread thread = new GugudanThread(inputDan);
            thread.start();

            // 주의: thread.run()이 아니라 thread.start()를 호출해야
            // 새로운 스레드(멀티 스레드)로 동작합니다.
        }

        sc.close();
    }
}