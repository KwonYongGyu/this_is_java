package com.mjc813.bookExample;

import static com.mjc813.bookExample.GenericExample.compare;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) {
		MySchool mjc813 = new MySchool();

		mjc813.getElementClass().add( new MyElementStudent("병아리1", 8, "김병아리"));
		mjc813.getElementClass().add( new MyElementStudent("병아리2", 9, "이병아리"));

		mjc813.getMiddleClass().add(new MyMiddleStudent("김사랑", 15, "국어1야간반"));
		mjc813.getMiddleClass().add(new MyMiddleStudent("이말자", 15, "수학1야간반"));

		mjc813.getStringClass().add("홍길동");
		mjc813.getStringClass().add("이순신");

		mjc813.getElementClass().printAll();
		mjc813.getMiddleClass().printAll();
		mjc813.getStringClass().printAll();

		Chapter13 ch13 = new Chapter13();
		ch13.GenericExample();
		ch13.GenericExample1();
		ch13.GenericExample2();
		ch13.GenericExample3();

		System.out.println();
		// 제너릭 메소드 호출
		boolean result1= compare(10,20);
		System.out.println(result1);
		System.out.println();

		// 제너릭 메소드 호출
		boolean result2 = compare(4.5, 4.5);
		System.out.println(result2);

		ch13.GenericExample5();
	}

}