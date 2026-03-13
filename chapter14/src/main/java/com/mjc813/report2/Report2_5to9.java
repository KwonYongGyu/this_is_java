package com.mjc813.report2;

public class Report2_5to9 implements Runnable {
	@Override
	public void run() {
		for ( int dan = 5; dan <= 9; dan ++ ) {
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
