package com.mjc813.report5;

import java.util.Comparator;
import java.util.List;

public class ThreadOfPrintDescEven implements Runnable {
	private List<Integer> list;
	public ThreadOfPrintDescEven(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		this.list.stream()
				.filter(x -> x % 2 == 0)
				.sorted(Comparator.reverseOrder())
				.forEach((x) -> {
					System.out.println("ThreadOfPrintDescEven : " + x );
				});
	}
}
