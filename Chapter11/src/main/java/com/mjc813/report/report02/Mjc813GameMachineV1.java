package com.mjc813.report.report02;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Mjc813GameMachineV1 {
	private int battery = 0;
	private MarioGame game1;

//	public Mjc813GameMachineV1(int bat, MarioGame game){
//		this.battery = bat;
//		this.game1 = game;
//	}
	public void runGame1() throws BatteryLessThan5Exception, Game1IsNullException {
		if ( this.battery < 5 ) {
			// 배터리 5% 미만 이라는 예외를 만들어서 던져보세요
			throw new BatteryLessThan5Exception(this.battery, "battery is lower than 5%");
			// 예외클래스 이름은 BatteryLessThan5Exception
		}
		if ( this.game1 == null ){
			// game1 소프트웨어가 없다 라는 예외를 만들어서 던져 보세요
		throw new Game1IsNullException("runGame1", "game1 software is null");
			// 예외클래스 이름은 Game1IsNullException
		}
		game1.runGame();
	}
}
