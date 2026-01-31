package com.mjc813;

import static com.mjc813.DaoExample.dbWork;
import static com.mjc813.SoundExample.printSound;

public class Chapter08 {

    public void RemoteControlExample() {

        RemoteControl rc;
        rc = new Television();
        rc.turnOn();
        // p.354
        rc.setVolume(5);
        rc.turnOff();

        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);
        rc.turnOff();

        // p.349
        System.out.println("리모콘 최대 불륨: " + RemoteControl.MAX_VOLUME);
        System.out.println("리모콘 최저 불륨: " + RemoteControl.MIN_VOLUME);
        // p.356
        rc.turnOn();
        rc.setVolume(5);

        // 디폴드 메소드 호출
        rc.setMute(true);
        rc.setMute(false);
        // p.358
        System.out.println();

        // Audio 객체를 생성하고 인터페이스 변수에 대입
        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);

        // 디폴트 메소드 호출
        rc.setMute(true);
        rc.setMute(false);

        // p.361
        System.out.println();

        // 정적 메소드 호출
        RemoteControl.changeBattery();
    }
    //p.363
    public void ServiceExample(){
        Service service = new ServiceImpl();

        // 디폴트 메소드 호출
        service.defaultMethod1();
        System.out.println();
        service.defaultMethod2();
        System.out.println();

        // 정적 메소드 호출
        Service.staticMethod1();
        System.out.println();
        Service.staticMethod2();
        System.out.println();
    }
    //p.366
    public void MultiInterfaceImplExample(){
        // RemoteControl1 인터페이스 변수 선언 및 구현 객체 대입
        RemoteControl1 rc = new SmartTelevision();
        //RemoteControl1 인터페이스에 선언된 추상 메소드만 호출 가능
        rc.turnOn();
        rc.turnOff();
        //Searchable 인터페이스 변수 선언 및 구현 객체 대입
        Searchable searchable = new SmartTelevision();
        //Searchable 인터페이스에 선언된 추상 메소드만 호출 가능
        searchable.search("https://www.youtube.com");
    }
    // p.369
    public void ExtendsExample(){
        InterFaceCImpl impl = new InterFaceCImpl();

        InterfaceA ia = impl;
        ia.methodA();
//        ia.methodB();
        System.out.println();

        InterfaceB ib = impl;
        ib.methodB();;
        System.out.println();

        InterfaceC ic = impl;
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
    // p.372
    public void PromotionExample(){
        // 구현 객체 생성
        B1 b = new B1();
        C1 c = new C1();
        D1 d = new D1();
        E1 e = new E1();

        // 인텊페이스 변수 선언
        A1 a;

        // 변수에 구현 객체 대입
        a = b;  // A <- B 자동 타입 변환
        a = c;  // A <- C 자동 타입 변환
        a = d;  // A <- D 자동 타입 변환
        a = e;  // A <- E 자동 타입 변환

    }
    // p.375
    public void CastingExample(){
        // 인터페이스 변수 선언과 구현 객체 대입
        Vehicle vehicle = new Bus();

        // 인터페이스를 통해서 호출
         vehicle.run();
         // vehicle.checkFare(); (x)

        // 강제 타입 변환 후 호출
        Bus bus = (Bus) vehicle;
        bus.run();
        bus.checkFare();
    }


    // 확인문제 5.
    public void ConfirmationProblem5() {
        Remocon r = new TV();
        r.powerOn();
    }

    // 확인문제 6.
    public void ConfirmationProblem6() {
        printSound(new Cat());
        printSound(new Dog());
    }

//    private void printSound(Soundable soundable){
//
//    }

    // 확인문제 7.
    public void ConfirmationProblem7() {
        dbWork(new OracleDao());
        dbWork(new MySqlDao());

    }

    // 확인문제 8.
    public void ConfirmationProblem8() {

        Example.action(new B());
        Example.action(new C());
    }
}
