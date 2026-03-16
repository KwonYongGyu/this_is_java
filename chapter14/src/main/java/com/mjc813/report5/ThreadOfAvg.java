package com.mjc813.report5;

import java.util.List;

public class ThreadOfAvg implements Runnable {
	private List<Integer> list;
	public ThreadOfAvg(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		Integer sum = this.list.stream().reduce(0, (x, y) -> x + y);
		Double avg = Double.parseDouble(sum.toString()) / this.list.size();
		System.out.println("ThreadOfAvg : " + avg);
	}
}
