package com.mjc813;

import java.nio.file.attribute.UserPrincipal;
import java.util.stream.StreamSupport;

public class Chapter07 {
    public void SmartPhoneExample(){
        SmartPhone myPhone = new SmartPhone("갤럭시", "은색");

        //  Phone로부터 상속받은 필드 읽기
        System.out.println("모델: " + myPhone.model);
        System.out.println("색상: " + myPhone.color);

        // SmartPhone의 필드 읽기
//        System.out.println("와이파이 상태: " +myPhone.wifi);

        // Phone으로부터 상속받은 메소드 호출
//        myPhone.bell();
//        myPhone.sendVoice("여보세요");
//        myPhone.receiveVoice("안녕하세요! 저는 홍길동인데요.");
//        myPhone.sendVoice("아~ 네, 반갑습니다.");
//        myPhone.hangUp();
//
//        // SmartPhone의 메소드 호출
//        myPhone.setWifi(true);
//        myPhone.internet();
    }

    // p.296
    public void ComputerExample(){
        int r = 10;

        Calculator calculator = new Calculator();
        System.out.println("원 면적: " + calculator.areaCircle(r));
        System.out.println();

        Computer computer = new Computer();
        System.out.println("원 면적: " + computer.areaCircle(r));
    }
    // p.300
    public void SupersonicAirplaneExample(){
        SupersonicAirplane sa = new SupersonicAirplane();
        sa.takeOff();
        sa.fly();
        sa.flyMode = SupersonicAirplane.SUPERSONIC;
        sa.fly();
        sa.flyMode = SupersonicAirplane.NORMAL;
        sa.fly();
        sa.land();
    }
    // p.309
    public void PromotionExample(){
        B1 b = new B1();
        C1 c = new C1();
        D1 d = new D1();
        E1 e = new E1();
        // 자동 타입 변환(상속 관계에 있음)
        A1 a1 = b;
        A1 a2 = c;
        A1 a3 = d;
        A1 a4 = e;

        B1 b1 = d;
        C1 c1 = e;

        // 컴파일 에러(상속 관계에 있지 않음)
        // B1 b3 = e1;
        // C1 c2 = d1;
    }

    // p.311
    public void ChildExample(){
        // 자식 객체 생성
        Child child = new Child();

        // 자동 타입 변환
        Parent parent = child;

        // 메소드 호출
        parent.method1();
        parent.method2();
        // parent.method3(); (호출 불가능)
    }
}
