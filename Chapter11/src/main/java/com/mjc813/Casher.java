package com.mjc813;

public class Casher {
	public void calculMoney(int ... arrs) {
		Calculator cal = new Calculator();
		double res = 0.0;
//		try {
			res = cal.divide(arrs);
//		} catch (Exception ex) {
//			System.err.println(ex.getMessage());
//		}
		System.out.println("res = " + res);
	}
}
