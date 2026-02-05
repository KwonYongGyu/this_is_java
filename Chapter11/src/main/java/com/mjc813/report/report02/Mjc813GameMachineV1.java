package com.mjc813.report.report02;

public class Mjc813GameMachineV1 {
	private int battery = 0;
	private MarioGame game1;

	public void runGame1() {
		if ( battery < 5 ) {
			// 배터리 5% 미만 이라는 예외를 만들어서 던져보세요
			throw new Throwable("runGame1", "battery is lower than 5%");
			// 예외클래스 이름은 BatteryLessThan5Exception
		}
		if ( game1 == null ) {
			// game1 소프트웨어가 없다 라는 예외를 만들어서 던져 보세요
			// 예외클래스 이름은 Game1IsNullException
		}
		game1.runGame();
	}
}
