package com.mjc813.report5;

import java.util.List;

public class ThreadOfSum implements Runnable {
	private List<Integer> list;
	public ThreadOfSum(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		Integer sum = this.list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("ThreadOfSum : " + sum);
	}
}
