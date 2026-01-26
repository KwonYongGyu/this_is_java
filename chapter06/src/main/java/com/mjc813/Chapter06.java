package com.mjc813;

import javax.annotation.processing.SupportedSourceVersion;

import static com.mjc813.Car7.simulate;
import ch06.sec12.hankook.SnowTire;
import ch06.sec12.kumho.AllSeasonTire;

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
        System.out.println("--------------------------------------------------------------------------");

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

    public void SmartPhoneExample(){
//        String company ;
//        String model;
//        String operatingSystem; // 운영체제
//        String display;    // 화면 인치 6.7,   6.1
//        String weight; // 25+ 190g, 14Pro 206g
//        String batterySize; // 4900mAh, 3200mAh
//        String usb; //Type-C, Lightning(USB2.0)
        SmartPhone sp1 = new SmartPhone("삼성", "Galaxy S25+", "One UI 7.0", "6.7inch","190g", "4900mAh", "Type-C");
        SmartPhone sp2 = new SmartPhone("애플", "iPhone 14Pro", "iOS 18", "6.1inch","206g", "3200mAh", "Lightning(USB2.0)");



        System.out.printf("%-15s\t%-25s\t%-25s%n", "Company", sp1.company, sp2.company);
        System.out.printf("%-15s\t%-25s\t%-25s%n", "Model", sp1.model, sp2.model);
        System.out.printf("%-15s\t%-25s\t%-25s%n", "OS", sp1.operatingSystem, sp2.operatingSystem);
        System.out.printf("%-15s\t%-25s\t%-25s%n", "Display", sp1.display, sp2.display);
        System.out.printf("%-15s\t%-25s\t%-25s%n", "Weight", sp1.weight, sp2.weight);
        System.out.printf("%-15s\t%-25s\t%-25s%n", "Battery", sp1.batterySize, sp2.batterySize);
        System.out.printf("%-15s\t%-25s\t%-25s%n", "USB", sp1.usb, sp2.usb);

    }

    public void nintendoExample() {

        NintendoGameInfo game1 = new NintendoGameInfo(
                "마리오 골프", "스포츠", "전체이용가", 20000
                , "https://pimg.mk.co.kr/news/cms/202504/06/news-p.v1.20250404.ad221f845db2489a86c2ff50f32c53fa_P1.png");

        NintendoGameInfo game2 = new NintendoGameInfo(
                "젤다의 전설", "RPG", "전체이용가", 30000
                , "https://store.nintendo.co.kr/media/catalog/product/cache/3be328691086628caca32d01ffcc430a/f/i/file.jpg");

        System.out.println("=== 닌텐도 게임 목록 ===");
        game1.displayInfo();
        game2.displayInfo();
    }
    public void RpgGameCharacterInfoExample(){
        RpgGameCharacterInfo char1 = new RpgGameCharacterInfo(
                "신사임당", "마법사", "여자", "2010-01-01", 203, 395, 10, 20, 10, 10
        );

        RpgGameCharacterInfo char2 = new RpgGameCharacterInfo(
                "흑색전사", "전사", "여자", "2010-01-01", 203, 395, 20, 5, 10, 5
        );

        RpgGameCharacterInfo char3 = new RpgGameCharacterInfo(
                "도적고양이", "도적", "여자", "2010-01-01", 203, 395, 15, 10, 20, 15
        );

        RpgGameCharacterInfo char4 = new RpgGameCharacterInfo(
                "못난이궁수", "궁수", "여자", "2010-01-01", 203, 395, 15, 10, 20, 15
        );


        // 2. 정보 출력
        System.out.println("=== RPG 캐릭터 목록 ===");
        char1.displayCharacter();
        char2.displayCharacter();
        char3.displayCharacter();
        char4.displayCharacter();
    }

    // p.245
    public void CarExample6(){
        Car6 myCar = new Car6("포르쉐");
        Car6 yourCar = new Car6("벤츠");

        myCar.run();
        yourCar.run();
    }
    // p.249
    public void CalculatorExample1(){
        double result1 = 10 * 0 * Calculator1.pi;
        int result2 = Calculator1.plus(10,5);
        int result3 = Calculator1.minus(10,5);

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);
    }
    // p.251
    public void TelevisionExample(){
        System.out.println(Television.info);
    }
    // p.254
    public void CarExample7(){
        simulate();

        Car7 myCar = new Car7();
        myCar.speed = 60;
        myCar.run();
    }
    // p.256
    public void KoreanExample2(){
        // 객체 생성 시 주민등록번호와 이름 전달
        Korean2 k2 = new Korean2("123456-1234567", "감자바");

        // 필드값 읽기
        System.out.println(k2.nation);
        System.out.println(k2.ssn);
        System.out.println(k2.name);

        // Final 필드는 값을 변경할 수 없음
        // k2.nation = "USA";
        // k2.ssn = "123-12-1234";

        // 비 final 필드는 값 변경 가능
        k2.name = "김자바";
    }
     public void EarthExample(){
        // 상수 읽기
         System.out.println("지구의 반지름: " + Earth.EARTH_RADIUS + "km");
         System.out.println("지구의 표면적: " + Earth.EARTH_SURFACE_AREA + "km^2");
     }
     // p.263
    public void CarExample8(){
        // 부품 필드 선언
        ch06.sec12.hankook.Tire tire1 = new ch06.sec12.hankook.Tire();
        ch06.sec12.kumho.Tire tire2 = new ch06.sec12.kumho.Tire();
        SnowTire tire3 = new SnowTire();
        AllSeasonTire tire4 = new AllSeasonTire();

    }
    // p.274
    public void CarExample9(){
        Car9 myCar = new Car9();

        // 잘못된 속도 변경
        myCar.setSpeed(-50);
        System.out.println("현재 속도: " + myCar.getSpeed());

        // 올바른 속도 변경
        myCar.setSpeed(60);
        System.out.println("현재 속도: " + myCar.getSpeed());

        // 멈춤
        if(!myCar.isStop()){
            myCar.setStop(true);
        }
        System.out.println("현재 속도: " + myCar.getSpeed());
    }

    // p.276
     public void SingletonExample(){
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        // 동일한 객체를 참조하는지 확인
        if(obj1 == obj2){
            System.out.println("같은 Singleton 객체입니다.");
        }
        else{
            System.out.println("다른 Singletion 객체입니다.");
        }
    }

}


