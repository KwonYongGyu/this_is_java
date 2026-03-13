package com.mjc813;

import com.mjc813.bookExample.SumThread;
import com.mjc813.bookExample.WorkThread;

import java.awt.*;

public class Chapter14 {
    public void BeepPrintExample() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();  // ToolKit 객체 얻기
        for (int i = 0; i < 5; i++) {
            toolkit.beep(); // 비프음 발생
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
        }
    }

    public void BeepPrintExample2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                }
            }
        });
        thread.start(); // 작업 스레드 실행

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }

    }

    public void BeepPrintExample3() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {

                    }
                }
            }
        };

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }

    public void ThreadNameExample() {
        Thread mainThread = Thread.currentThread(); // 이 코드를 실행하는 스레드 객체 참조 얻기
        System.out.println(mainThread.getName() + " 실행");

        for(int i = 0; i < 3; i++) {
            Thread threadA = new Thread() {
                @Override
                public void run() {
                    System.out.println(getName() + "실행");
                }
            };
            threadA.start();
        }

        Thread chatThread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " 실행");
            }
        };
        chatThread.setName("chat-thread");
        chatThread.start();
    }

    public void SleepExample() {
        Toolkit toolkit = Toolkit.getDefaultToolkit(); // ToolKit 객체 얻기
        for (int i = 0; i < 10; i++) {
            toolkit.beep(); // 비프음 발생
            try {
                Thread.sleep(3000); // 3초간 일시 정지
            } catch (InterruptedException e) {

            }
        }
    }

    public void JoinExample() {
        SumThread sumThread = new SumThread();
        sumThread.start();
        try {
            sumThread.join();
        } catch (InterruptedException e) {

        }
        System.out.println("1~100 합: " + sumThread.getSum());
    }

    public void YieldExample() {
        WorkThread workThreadA = new WorkThread("workThreadA");
        WorkThread workThreadB = new WorkThread("workThreadB");
        workThreadA.start();
        workThreadB.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        workThreadA.work = false;
        try {
            Thread.sleep(10000);

        } catch ( InterruptedException e) {
        }
        workThreadA.work = true;
        }
    }
}
