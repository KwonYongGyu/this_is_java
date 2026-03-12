package com.mjc813;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Thread1 th1 = new Thread1(29);
//
//		Thread3 th3 = new Thread3();
//		for ( int i = 0; i < 99; i++ ) {
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//			}
//			th1.start();
//			System.out.println(String.format("%s, i = %d", Thread.currentThread().getName(), i));
//			if ( i % 10 == 0 ) {
//				th3.testThread3();
//			}
//		}
//		//스레드실행
//		th3.close();



        Chapter14 ch14 = new Chapter14();
//        ch14.BeepPrintExample();
//        ch14.BeepPrintExample2();
//		ch14.BeepPrintExample3();
        ch14.ThreadNameExample();
    }
}