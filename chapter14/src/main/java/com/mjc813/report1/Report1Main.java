package com.mjc813.report1;

public class Report1Main {
	public static void main(String[] args) {
		for ( int dan = 2; dan <= 9; dan ++ ) {
			for ( int num = 1; num <= 9; num++ ) {
				System.out.println(String.format("%d * %d = %d", dan, num, dan*num));
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
