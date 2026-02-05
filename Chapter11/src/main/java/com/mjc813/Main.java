package com.mjc813;

import com.mjc813.Example.Driving;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) {
		Casher casher = new Casher();
		try {
			casher.calculMoney();
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.err.println("ArrayIndexOutOfBoundsException : " + ex.getMessage());
		} catch (Exception ex) {
			System.err.println("Exception : " + ex.getMessage());
		}
		System.out.println("finish execute !");
	}

	public void TestDriving(Integer pedal){
		Driving driving = new Driving();
		driving.go(pedal);
		driving.go(4);
		driving.go(8);
		driving.stop(pedal);
		driving.stop(3);
		driving.stop(0);
	}
}