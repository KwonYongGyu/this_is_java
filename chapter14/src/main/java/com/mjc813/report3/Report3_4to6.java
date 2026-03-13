package com.mjc813.report3;

public class Report3_4to6 implements Runnable {
    @Override
    public void run() {
        for ( int dan = 4; dan <= 6; dan ++ ) {
            for ( int num = 1; num <= 9; num++ ) {
                System.out.println(String.format("%d * %d = %d", dan, num, dan*num));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
