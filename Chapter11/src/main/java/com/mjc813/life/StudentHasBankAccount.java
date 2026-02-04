package com.mjc813.life;

import com.mjc813.banking.BankAccount;
import com.mjc813.student.Student;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class StudentHasBankAccount {
	private final Student student;
	private final BankAccount bankAccount;

	/**
	 * 계좌에 돈을 입금한다.
	 * @param money
	 */
	public void income(int money) {
		bankAccount.setMoney( bankAccount.getMoney() + money );
	}

	/**
	 * 계좌에서 돈을 출금한다.
	 * @param money
	 */
	public int outcome(int money) {
		bankAccount.setMoney( bankAccount.getMoney() - money );
		return bankAccount.getMoney();
	}

	/**
	 * 계좌의 현재 금액을 리턴한다.
	 * @return
	 */
	public int getCurrentMoney() {
		return this.bankAccount.getMoney();
	}
}
