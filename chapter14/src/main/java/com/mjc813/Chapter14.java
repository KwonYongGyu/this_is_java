package com.mjc813;

import com.mjc813.bookExample.*;

import java.awt.*;
import java.nio.channels.WritePendingException;
import java.util.concurrent.*;

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

        for (int i = 0; i < 3; i++) {
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

        } catch (InterruptedException e) {
        }
        workThreadA.work = true;
    }

    public void SynchronizedExample() {
        Calculator calculator = new Calculator();

        User1Thread user1Thread = new User1Thread();
        user1Thread.setCalculator(calculator);
        user1Thread.start();

        User2Thread user2Thread = new User2Thread();
        user2Thread.setCalculator(calculator);
        user2Thread.start();
    }

    public void WaitNotifyExample() {
        WorkObject workObject = new WorkObject(); // 공유 작업 객체 생성

        ThreadA threadA = new ThreadA(workObject);
        Thread threadB = new ThreadB(workObject);

        threadA.start();
        threadB.start();
    }

    public void SafeStopExample() {
        PrintThread printThread = new PrintThread();
        printThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        printThread.setStop(true); // PrintThread를 종료하기 위해 stop 필드값 변경
    }

    public void InterruptExample() {
        Thread thread = new PrintThread();
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

        thread.interrupt();
    }

    public void InterruptExample2() {
        Thread thread = new PrintThread();
        thread.start();

        try {
            Thread.sleep(1000); // 1초 동안 대기
        } catch (InterruptedException e) {

        }

        thread.interrupt();
    }

    public void DaemonExample() {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true); // AutoSaveThread를 데몬 스레드로 만듦
        autoSaveThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        System.out.println("메인 스레드 종료");
    }

    public void ExecutorServiceExample() {
        // 스레드 풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 작업 생성과 처리 요청
        // 스레드풀 종료
        executorService.shutdown();
    }

    public void RunnableExecuteExample() {
        // 1000개의 메일 생성
        String[][] mails = new String[1000][3];
        for(int i = 0; i < mails.length; i++) {
            mails[i][0] = "admin@my.com";
            mails[i][1] = "member" + i + "@my.com";
            mails[i][2] = "신상품 입고";
        }
        // ExecutorService 생성
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 임일을 보내는 작업 생성 및 처리 요청
        for(int i = 0; i < 1000; i++) {
            final int idx = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Thread thread = Thread.currentThread();
                    String from = mails[idx][0];
                    String to = mails[idx][1];
                    String content = mails[idx][2];
                    System.out.println("[" + thread.getName() + "] " +
                            from + " ==> " + to + ": " + content);
                }
            });
        }

        // ExecutorService 종료
        executorService.shutdown();
    }

    public void CallableSubmitExample() {
        // ExecutorService 생성
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 계산 작업 생성 및 처리 요청
        for (int i  = 1; i<= 100; i++) {
            final int idx = i;
            Future<Integer> future = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception{
                    int sum = 0;
                    for(int i = 1; i <= idx; i++) {
                        sum += i;
                    }
                    Thread thread = Thread.currentThread();
                    System.out.println("[" + thread.getName() + "] 1~" + idx + "합 계산");
                    return sum; // 작업 처리 결과 리턴
                }
            });

            try {
                int result = future.get(); // Callable의 call 메소드가 리턴한 값 얻기
                System.out.println("\t리턴값: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //ExecutorService 종료
        executorService.shutdown();
    }
}

