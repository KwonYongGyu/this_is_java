package com.mjc813.report3;

import com.mjc813.report2.Report2_5to9;

public class Report3Main {
    public static void main(String[] args) {


//        Thread r2 = new Thread(new Report2_5to9());
        Thread r3 = new Thread(new Report3_4to6());
        Thread r4 = new Thread(new Report3_7to9());
        r3.start();
        r4.start();
        for (int dan = 2; dan <= 3; dan++) {
            for (int num = 1; num <= 9; num++) {
                System.out.println(String.format("%d * %d = %d", dan, num, dan * num));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
