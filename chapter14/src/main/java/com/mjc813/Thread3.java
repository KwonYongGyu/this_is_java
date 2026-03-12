package com.mjc813;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Thread3 {
	ExecutorService es = Executors.newFixedThreadPool(10);

	public void testThread3() {
		this.es.execute(new Thread2());

		Future<Integer> result = this.es.submit(new CallableClass(1, 100000));
		try {
			System.out.println(String.format("Thread3, result = %d", result.get()));
		} catch (InterruptedException e) {
			System.err.println(e.toString());
		} catch (ExecutionException e) {
			System.err.println(e.toString());
		}
	}

	public void close() {
		this.es.shutdown();
	}
}
