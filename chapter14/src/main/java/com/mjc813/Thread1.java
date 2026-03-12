package com.mjc813;

public class Thread1 extends Thread {
	public Thread1(int num) {
		this.num = num;
		this.setName("Thread1");
	}
	private int num;

	@Override
	public void run() {
		Thread th2 = new Thread(new Thread2());
		th2.start();

		for ( int i = 0; i < this.num; i++ ) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println(String.format("%s, i = %d", Thread.currentThread().getName(), i));
		}
	}
}
