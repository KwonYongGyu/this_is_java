package com.mjc813.report5;

import java.util.List;

public class ThreadOfOdd implements Runnable{
	private List<Integer> list;
	public ThreadOfOdd(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		this.list.stream().filter(x -> x % 2 != 0).forEach((x) -> {
			System.out.println("ThreadOfOdd : " + x );
		});
	}
}
