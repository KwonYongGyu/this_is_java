package com.mjc813;

import java.util.Scanner;

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
    // 개인과제 4
    //학생이 강의를 수강해서 성적을 받는 생활을 클래스 설계 해보세요.
    //	클래스는 학생, 강의과목, 학생이 과목을 수강 하고 성적을 받는 과정의
    //	데이터가 잘 저장되고 표현 되도록 설계 해보세요.
    //	정답은 없으므로 여러분의 경험에 기반하여 클래스를 만들어 봅니다.
    //	속성과 동작을 잘 구분하여 만들고 Lombok 을 활용 합니다.
    //	클래스 이름 속성, 동작 이름은 자유롭습니다.
    //	설계한 소스는 개인과제 git 리포지토리에 올립니다.
    //	기한은 약 1~3시간 정도 개발할 양이면 됩니다. 너무 적어도 많아도 안됩니다.
    public void GetGradeExample(){
//        AttendLecture[] AttendArray = new AttendLecture[];
        Scanner scanner = new Scanner(System.in);
        boolean run = true; // while문의 조건식을 위한 변수 선언

        while(run){
            System.out.println("--------------------------------------------------");
            System.out.println("1.학생정보 | 2.수강과목 | 3.성적 | 4.등급 | 5.수업관리 | 6.종료");
            System.out.println("--------------------------------------------------");
            System.out.print("선택> ");

            int selectNo = Integer.parseInt(scanner.nextLine());

            if (selectNo == 1) {
                // 학생
                System.out.println("----------\\학생정보\\n----------\"");
                System.out.print("이름: ");
                String studentName = scanner.nextLine();
                System.out.print("학번: ");
                String studentId = scanner.nextLine();

                GetGrade gg = new GetGrade(studentName, studentId);
            }
        }
    }

}
