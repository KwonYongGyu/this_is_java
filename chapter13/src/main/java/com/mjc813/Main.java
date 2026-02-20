package com.mjc813;

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

	}
}