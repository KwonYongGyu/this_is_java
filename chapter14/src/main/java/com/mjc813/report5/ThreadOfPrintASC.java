package com.mjc813.report5;

import java.util.List;

public class ThreadOfPrintASC implements Runnable {
	private List<Integer> list;
	public ThreadOfPrintASC(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		this.list.stream().sorted().forEach((x) -> {
			System.out.println("ThreadOfPrintASC : " + x );
		});
	}
}
