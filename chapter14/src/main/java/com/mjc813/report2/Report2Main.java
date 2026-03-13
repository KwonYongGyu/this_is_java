package com.mjc813.report2;

public class Report2Main {
	public static void main(String[] args) {
// 익명객체를 사용하는 방법은 1회성으로 끝나기 때문에 유지보수가 어렵다.
// 익명객체를 사용하면 데이터를 줄수도 받을 수도 없다.
//		Thread r2 = new Thread() {
//			@Override
//			public void run() {
//				for ( int dan = 5; dan <= 9; dan ++ ) {
//					for ( int num = 1; num <= 9; num++ ) {
//						System.out.println(String.format("%d * %d = %d", dan, num, dan*num));
//						try {
//							Thread.sleep(50);
//						} catch (InterruptedException e) {
//						}
//					}
//				}
//			}
//		};
//		r2.start();

		Thread r2 = new Thread(new Report2_5to9());
		r2.start();

		for ( int dan = 2; dan <= 4; dan ++ ) {
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
