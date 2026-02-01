package com.mjc813;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.mjc813.InstanceofExample.personInfo;

public class Chapter07 {
    public void SmartPhoneExample() {
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
    public void ComputerExample() {
        int r = 10;

        Calculator calculator = new Calculator();
        System.out.println("원 면적: " + calculator.areaCircle(r));
        System.out.println();

        Computer computer = new Computer();
        System.out.println("원 면적: " + computer.areaCircle(r));
    }

    // p.300
    public void SupersonicAirplaneExample() {
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
    public void PromotionExample() {
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
    public void ChildExample() {
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
    public void GetGradeExample() {
        Scanner scanner = new Scanner(System.in);
        // 학생정보 저장
        List<GetGrade> studentList = new ArrayList<>();

        String name = "";
        String id = "";
        String lecture = "";
        int score = 0;
        boolean run = true;

        while (run) {
            System.out.println("\n--------------------------------------------------");
            System.out.println("1.학생정보 | 2.수강과목 | 3.성적입력 | 4.현재정보확인 | 5.수업관리(전체) | 6.종료");
            System.out.println("--------------------------------------------------");
            System.out.print("선택> ");

            int selectNo = Integer.parseInt(scanner.nextLine());
            // 학생 정보
            switch (selectNo) {
                case 1:
                    System.out.print("이름: ");
                    name = scanner.nextLine();
                    System.out.print("학번: ");
                    id = scanner.nextLine();
                    System.out.println("=> 학생 정보가 설정되었습니다.");
                    break;
                // 수강 과목
                case 2:
                    System.out.print("수강할 과목명: ");
                    lecture = scanner.nextLine();
                    System.out.println("=> 과목 정보가 설정되었습니다.");
                    break;
                // 성적 입력
                case 3:
                    System.out.print("성적 점수(0~100): ");
                    score = Integer.parseInt(scanner.nextLine());
                    System.out.println("=> 성적이 입력되었습니다.");
                    break;
                // 현재 입력한 정보를 리스트에 추가 (저장)
                case 4:
                    if (name.isEmpty() || lecture.isEmpty()) {
                        //.isEmpty() 빈문자열일경우 true를 반환
                        System.out.println("! 학생 정보와 과목을 먼저 입력해주세요.");
                    } else {
                        GetGrade student = new GetGrade(name, id, lecture, score);
                        studentList.add(student);
                        System.out.println("=> 현재 정보가 시스템에 등록되었습니다.");
                        System.out.println(student.toString());
                    }
                    break;
                // 수업관리
                case 5:
                    System.out.println("\n========== [전체 수업 관리 현황] ==========");
                    if (studentList.isEmpty()) {
                        System.out.println("등록된 정보가 없습니다.");
                    } else {
                        for (GetGrade s : studentList) {
                            System.out.printf("[학생: %s] 과목: %s | 등급: %s\n",
                                    s.getStudentName(), s.getLecture(), s.getGradeLevel());
                        }
                    }
                    System.out.println("=========================================");
                    break;
                // 종료
                case 6:
                    run = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;

                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }

    // p.318 다형성
    public void CarExample1() {
        // Car 객체 생성
//        Car1 myCar = new Car1();
        // 생성자 사용 방법
        Car1 myCar1 = new Car1(new HankookTire());
        myCar1.run();
        Car1 myCar2 = new Car1(new KumhoTire());
        myCar2.run();
        // Tire 객체 장착
//        myCar.tire = new Tire();
//        myCar.run();
        // Setter 사용 방법
//        myCar.setTire(new Tire());
//        myCar.run();

        // HankookTire 객체 장착
//        myCar.tire = new HankookTire();
//        myCar.run();
//        myCar.setTire(new HankookTire());
//        myCar.run();

        // KumhoTire 객체 장착
//        myCar.tire = new Kumhotire();
//        myCar.run();
//        myCar.setTire(new Kumhotire());
//        myCar.run();


    }

    // p.322 매개변수의 다형성
    public void DriverExample() {
    // Driver 객체 생성
        Driver driver = new Driver();

        // 매개값으로 Bus 객체를 제공하고 driver() 메소드 호출
        Bus bus = new Bus();
        driver.drive(bus);
        // driver.drive(bus);
        // 와 동일

        // 매개값으로 Taxi 객체를 제공하고 driver() 메소드 호출
        Taxi taxi = new Taxi();
        driver.drive(taxi);
        // driver.drive(taxi);
        // 와 동일
    }

    // p.324
    public void InstanceofExampleMain(){
        Person p1 = new Person("홍길동");
        personInfo(p1);

        System.out.println();

        // Student 객체를 매개값으로 제공하고 personInfo() 메소드 호출
        Person p2 = new Student("김길동", 10);
        personInfo(p2);

        // 이름 수정시(Setter 활용 예시)
        p1.setName("이길동");
        // personInfo(p1) // 이름이 변경된것을 확인 가능
    }

    // p.328
    public void PhoneExample1(){
        SmartPhone1 smartPhone = new SmartPhone1("홍길동");

        smartPhone.turnOn();
        smartPhone.internetSearch();
        smartPhone.turnOff();
    }
    // p.331
    public void AbstractMethodExample(){
//        Dog dog = new Dog();
//        dog.sound();
//
//        Cat cat = new Cat();
//        cat.sound();
//
//        // 매개변수의 다형성
//        animalSound(new Dog()); // (dog);
//        animalSound(new Cat()); // (cat);
        Dog dog = new Dog();
        System.out.println("동물 종류: " + dog.getKind()); // Getter 사용
        dog.sound();
        dog.breath();

        System.out.println();

        Cat cat = new Cat();
        System.out.println("동물 종류: " + cat.getKind()); // Getter 사용
        cat.sound();
        cat.breath();

        System.out.println("\n--- 매개변수 다형성 실행 ---");
        animalSound(new Dog());
        animalSound(new Cat());
    }

    private void animalSound(Animal animal) {
        // animal이 어떤 자식 객체냐에 따라 각기 다른 sound()가 실행됨
        System.out.print(animal.getKind() + "의 소리: ");
        animal.sound();
    }

//    private void animalSound(Animal animal) {
//        animal.sound();
//    }
    // p.334
    public void SealedExample(){
        Person1 p = new Person1();
        p.setName("홀길동");

        Employee e = new Employee("김철수");
        Manager m = new Manager("이영희");
        Director d = new Director("박본부");

        p.work();
        e.work();
        m.work();
        d.work();

    }
    // 확인문제 8
    public void SnowTireExample(){
        SnowTire snowTire = new SnowTire();
        Tire1 tire1 = snowTire;

        snowTire.run();
        tire1.run();
    }
    // 확인문제 9
//    public void extendsExample(){
//        B1 b = new B1();
//        // new B1();
//        // (B1) new A1();
//        // new D1();
//        // new E1();
//
//        void method(B1 b){
//
//        }
//        method(new B1())
//    }
// 확인문제 11
    public void MainActivityExample(){
        MainActivity main = new MainActivity();
        main.onCreate();
    }
    // 확인문제 12
//    public void Example(){
////        C12 c = new C12();
////        A12 a = new A12();
//        public static void action(A12 a){
//            a.method1();
//            if(a instanceof C12 c){
//                C12 c;
//                c.method2();
//            }
//        }
//        action(new A12());
//        action(new B12());
//        action(new C12());
//
//    }

    // 1/29일
    public void ChildExample1(){
        Child1 child = new Child1();
    }
    // 개인과제
    public void Animal1Example(){
        Animal1 rabbit = new Rabbit("2살", "40cm");
        Animal1 tiger = new Tiger("6살", "250cm");
        Animal1 fox = new Fox("4살", "80cm");
        Animal1 swan = new Swan("3살", "110cm");

        System.out.println("==== 동물 상태 보고 ====");
        printInfo(rabbit);
        printInfo(tiger);
        printInfo(fox);
        printInfo(swan);

        System.out.println("\n==== 먹이사슬 ====");
        // 토끼는 Swan만 먹는다
        System.out.println("1. 토끼의 식사: " + rabbit.eat(swan));
        System.out.println("2. 토끼의 식사: " + rabbit.eat(tiger));

        // 호랑이는 토끼만 먹는다
        System.out.println("3. 호랑이의 식사: " + tiger.eat(rabbit));

        // 여우는 Swan, 토끼를 먹는다
        System.out.println("4. 여우의 식사(Swan): " + fox.eat(swan));
        System.out.println("5. 여우의 식사(Rabbit): " + fox.eat(rabbit));

        // Swam은 먹지 못함
        System.out.println("6. Swan의 식사: " + swan.eat(fox));
    }

    public static void printInfo(Animal1 animal) {
        System.out.println("[" + animal.getClass().getSimpleName() + "]");
        System.out.println(" - 울음소리: " + animal.sound());
        System.out.println(" - 나이: " + animal.age());
        System.out.println(" - 크기: " + animal.size());
        animal.breathe();
    }

}
