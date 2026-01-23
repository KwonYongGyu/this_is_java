package com.mjc813;

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

}


