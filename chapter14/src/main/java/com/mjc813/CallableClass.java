package com.mjc813;

import java.util.concurrent.Callable;

public class CallableClass implements Callable<Integer> {
	private int start;
	private int end;

	public CallableClass(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public Integer call() throws Exception {
		int result = 0;
		for ( int i = start; i <= end; i++ ) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
			}
			result += i;
		}
		System.out.println(String.format("%s, result = %d", Thread.currentThread().getName(), result));
		return result;
	}
}
