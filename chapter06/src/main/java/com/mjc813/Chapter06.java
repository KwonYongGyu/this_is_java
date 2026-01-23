package com.mjc813;

import javax.annotation.processing.SupportedSourceVersion;

public class Chapter06 {

    public class Student {

    }

    // p.212
    public void StudentExample() {
        Student s1 = new Student();
        System.out.println("s1 변수가 Student 객체를 참조합니다. ");

        Student s2 = new Student();
        System.out.println("s2 변수가 또 다른 Student 객체를 참조합니다.");
    }


    public void CarExample() {
        Car myCar = new Car();

        // Car 객체의 필드값 읽기
        System.out.println("모델명: " + myCar.model);
        System.out.println("시동여부: " + myCar.start);
        System.out.println("현재속도: " + myCar.speed);
    }


    public void CarExample1() {
        // Car1 객체 생성
        Car1 myCar1 = new Car1();

        // Car1 객체의 필드값 읽기
        System.out.println("제작회사: " + myCar1.company);
        System.out.println("모델명: " + myCar1.model);
        System.out.println("색깔: " + myCar1.color);
        System.out.println("최고속도: " + myCar1.maxSpeed);
        System.out.println("현재속도: " + myCar1.speed);

        // Car1 객체의 필드값 변경
        myCar1.speed = 60;
        System.out.println("수정된 속도: " + myCar1.speed);
    }

    public void CarExample2() {
        Car2 myCar2 = new Car2("그랜저, 검정", 250);
    }

    // p.233
    public void KoeranExample() {
        // Korean 객체 생성
        Korean k1 = new Korean("박자바", "011225-1234567");
        // Korean 객체 데이터 읽기
        System.out.println("k1.nation : " + k1.nation);
        System.out.println("k1.name : " + k1.name);
        System.out.println("k1.ssn : " + k1.ssn);
        System.out.println();

        // 또 다른 Korean 객체 생성
        Korean k2 = new Korean("김자바", "930525-0654321");
        // 또 다른 Korean 객체 데이터 읽기
        System.out.println("k2.nation : " + k2.nation);
        System.out.println("k2.name : " + k2.name);
        System.out.println("k2.ssn : " + k2.ssn);


    }
    public void CarExample3(){
        Car3 car1 = new Car3();
        System.out.println("car1.company : " + car1.company);
        System.out.println();

        Car3 car2 = new Car3("자가용");
        System.out.println("car2.company : " + car2.company);
        System.out.println("car2.model : " + car2.model);
        System.out.println();

        Car3 car3 = new Car3("자가용", "빨강");
        System.out.println("car3.company : " + car3.company);
        System.out.println("car3.model : " + car3.model);
        System.out.println("car3.color : " + car3.color);
        System.out.println();

        Car3 car4 = new Car3("택시", "검정", 200);
        System.out.println("car4.company : " + car4.company);
        System.out.println("car4.model : " + car4.model);
        System.out.println("car4.color : " + car4.color);
        System.out.println("car4.maxSpeed : " + car4.maxSpeed);


    }

    // p.231
    public void CarExample4(){
        Car4 car1 = new Car4("자가용");
        System.out.println("car1.company : " + car1.company);
        System.out.println("car1.model : " + car1.model);
        System.out.println();

        Car4 car2 = new Car4("자가용", "빨강");
        System.out.println("car2.company : " + car2.company);
        System.out.println("car2.model : " + car2.model);
        System.out.println("car2.color : " + car2.color);
        System.out.println();

        Car4 car3 = new Car4("택시", "검정", 200);
        System.out.println("car3.company : " + car3.company);
        System.out.println("car3.model : " + car3.model);
        System.out.println("car3.color : " + car3.color);
        System.out.println("car3.maxSpeed : " + car3.maxSpeed);

    }

//    p.235
    public void CalculatorExample(){
        // Calculator 객체 생성
        Calculator myCalc = new Calculator();

        // 리턴값이 없는 powerOn() 메소드 호출
        myCalc.powerOn();

        // plus 메소드 호출 시 5와 6을 매개값으로 제공하고,
        // 덧셈 결과를 리턴받아 result1 변수에 대입
        int result1= myCalc.plus(5, 6);
        System.out.println("result1: " + result1);

        int x = 10;
        int y = 4;
        // divide() 메소드 호출 시 변수 x와 y의 값을 매개값으로 제공하고,
        // 나눗셈 결과를 리턴받아 result2 변수에 대입
        double result2 = myCalc.divide(x, y);
        System.out.println("result2: " + result2);

        // 리턴값이 없는 powerOff() 메소드 호출
        myCalc.powerOff();
    }

    // p.237
    public void ComputerExample(){
        // Computer 객체 생성
        Computer myCom = new Computer();

        // sum() 메소드 호출 시 매개값 1, 2, 3을 제공하고
        // 합산 결과를 리턴받아 result1 변수에 대입
        int result1 = myCom.sum(1, 2, 3);
        System.out.println("result1: " + result1);

        // sum() 메소드를 호출 시 매개값 1, 2, 3, 4, 5를 제공하고
        // 합산 결과를 리턴받아 result2 변수에 대입
        int result2 = myCom.sum(1, 2, 3, 4, 5);
        System.out.println("result2: " + result2);

        // sum() 메소드 호출 시 배열을 제공하고
        // 합산 결과를 리턴받아 result3 변수에 대입
        int[] values = { 1, 2, 3, 4, 5 };
        int result3 = myCom.sum(values);
        System.out.println("result3: " + result3);

        // sum() 메소드 호출 시 배열을 제공하고
        // 합산 결과를 리턴받아 result3 변수에 대입
        int result4 = myCom.sum(new int[] { 1, 2, 3, 4, 5 });
        System.out.println("result4: " + result4);
    }

    public void CarExample5(){
        // Car5 객체 생성
        Car5 myCar = new Car5();

        // 리턴값이 없는 setGas() 메소드 호출
        myCar.setGas(5);

        //isLeftGas() 메소드를 호출해서 받은 리턴값이 true일 경우 if 블록 실행
        if(myCar.ifLeftGas()){
            System.out.println("출발합니다.");

            // 리턴값이 없는 run() 메소드 호출
            myCar.run();
        }

        System.out.println("gas를 주입하세요.");
    }
    // p.243
    public void RectangleCalculatorExample(){
        // 객체 생성
        RectangleCalculator rc = new RectangleCalculator();

        // 정사각형의 넓이 구하기
        double result1 = rc.areaRectangle(10);

        // 직사각형의 넓이 구하기
        double result2 = rc.areaRectangle(10, 20);

        System.out.println("정사각형의 넓이=" + result1);
        System.out.println("직사각형의 넓이=" + result2);
    }
}


