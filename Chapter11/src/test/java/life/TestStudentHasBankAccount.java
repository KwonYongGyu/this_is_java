package life;

import com.mjc813.banking.BankAccount;
import com.mjc813.banking.IMachine;
import com.mjc813.banking.MachineNotWorkingException;
import com.mjc813.life.LifeOfStduentWithBank;
import com.mjc813.life.StudentHasBankAccount;
import com.mjc813.student.Student;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestStudentHasBankAccount {
	@Test
	public void TestIncome() {
		com.mjc813.life.StudentHasBankAccount stuBank = new com.mjc813.life.StudentHasBankAccount(
				new Student("홍길동", "hhh1111")
				, new BankAccount("77-777-77-77", "홍길동")
		);
		assertThat(stuBank.getCurrentMoney()).isEqualTo(0);
		stuBank.income(1000);
		stuBank.income(5000);
		stuBank.income(82000);
		assertThat(stuBank.getCurrentMoney()).isEqualTo(88000);
	}

	@Test
	public void TestOutcome() {
		com.mjc813.life.StudentHasBankAccount stuBank = new com.mjc813.life.StudentHasBankAccount(
				new Student("홍길동", "hhh1111")
				, new BankAccount("77-777-77-77", "홍길동")
		);
		assertThat(stuBank.getCurrentMoney()).isEqualTo(0);
		stuBank.income(100000);
		stuBank.outcome(20000);
		stuBank.outcome(3000);
		assertThat(stuBank.getCurrentMoney()).isEqualTo(77000);
	}

	@Test
	public void TestGetCurrentMoney() {
		com.mjc813.life.StudentHasBankAccount stuBank = new com.mjc813.life.StudentHasBankAccount(
				new Student("홍길동", "hhh1111")
				, new BankAccount("77-777-77-77", "홍길동")
		);
		assertThat(stuBank.getCurrentMoney()).isEqualTo(0);
		stuBank.income(100000);
		stuBank.outcome(10000);
		assertThat(stuBank.getCurrentMoney()).isEqualTo(90000);
	}

	@Test
	public void TestSendMoney() {
		com.mjc813.life.StudentHasBankAccount stuBank1 = new com.mjc813.life.StudentHasBankAccount(
				new Student("홍길동", "hhh1111")
				, new BankAccount("77-777-77-77", "홍길동")
		);
		com.mjc813.life.StudentHasBankAccount stuBank2 = new StudentHasBankAccount(
				new Student("이순신", "lss9876")
				, new BankAccount("567-372-2983", "이순신")
		);
		IMachine allGoodMachine = new IMachine() {
			// 항상 true를 반환하도록 익명 클래스로 만들어짐
			@Override
			public boolean isActive() throws MachineNotWorkingException {
				return true;
			}
		};
		IMachine brokenMachine = new IMachine() {
			@Override
			public boolean isActive() throws MachineNotWorkingException {
				return false;
			}
		};
		com.mjc813.life.LifeOfStduentWithBank losw = new com.mjc813.life.LifeOfStduentWithBank(allGoodMachine);
		losw.sendMoney(stuBank1, stuBank2, 50000); // 학생 1이 돈이 빠져나가 학생 2에게 들어감
		assertThat(stuBank1.getBankAccount().getMoney()).isEqualTo(-50000);	// 돈이 잘 옮겨 졌는지 확인
		assertThat(stuBank2.getBankAccount().getMoney()).isEqualTo(50000);

		com.mjc813.life.LifeOfStduentWithBank brokenSWB = new LifeOfStduentWithBank(brokenMachine);
		brokenSWB.sendMoney(stuBank2, stuBank1, 10000);
		assertThat(stuBank1.getBankAccount().getMoney()).isEqualTo(-50000);
		assertThat(stuBank2.getBankAccount().getMoney()).isEqualTo(50000);
	}
}
