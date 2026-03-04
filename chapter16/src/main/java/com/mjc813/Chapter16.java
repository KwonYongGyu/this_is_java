package com.mjc813;

import com.mjc813.bookExample.*;

public class Chapter16 {
    public void LamdaExample1(){
        action((x, y) -> {
            int result = x + y;
            System.out.println("result: " + result );
        });

        action((x, y) -> {
            int result = x - y;
            System.out.println("result: " + result);
        });
    }
    public static void action(Calculable calculable) {
        // 데이터
        int x = 10;
        int y = 4;
        // 데이터 처리
        calculable.calculate(x, y);
    }

    public void LamdaExample2(){
        Person person = new Person();

        // 실행문이 두 개 이상인 경우 중괄호 필요
        person.action(() -> {
            System.out.println("출근을 합니다.");
            System.out.println("프로그래밍을 합니다.");
        });

        // 실행문이 한 개일 경우 중괄호 생략 가능
        person.action(() -> System.out.println("퇴근합니다."));
    }

    public void ButtonExample(){
        // Ok 버튼 객체 생성
        Button btnOk = new Button();

        // Ok 버튼 객체에 람다식(ClickListener 익명 구현 객체) 주입
        btnOk.setClickListener(() -> {
            System.out.println("Ok 버튼을 클릭했습니다.");
        });

        // Ok 버튼 클릭하기
        btnOk.click();

        // Cancel 버튼 객체 생성
        Button btnCancel = new Button();

        // Cancel 버튼 객체에 람다식(ClickListener 익명 구현 객체) 주입
        btnCancel.setClickListener(() -> {
            System.out.println("Cancel 버튼을 클릭했습니다.");
        });

        // Cancel 버튼 클릭하기
        btnCancel.click();
    }

    public void LamdaExample3(){
        Person2 person2 = new Person2();

        // 매개변수가 두 개일 경우
        person2.action1((name, job) -> {
            System.out.print(name + "이 ");
            System.out.println(job + "을 합니다.");
        });
        person2.action1((name, job) ->
            System.out.println(name + "이 " + job + "을 하지 않습니다."));

        // 매개변수가 한 개일 경우
        person2.action2(word -> {
            System.out.print("\"" + word + "\"");
            System.out.println("라고 말합니다.");
        });
        person2.action2(word -> System.out.println("\"" + word + "\"라고 외칩니다."));
    }

    public void LamdaExample4() {
        Person3 person3 = new Person3();

        // 실행문이 두 개 이상일 경우
        person3.action((x, y) -> {
            double result = x + y;
            return result;
        });

        // 리턴문이 하나만 있을 경우(연산식)
        // person3.action((x, y) -> {
        // });
        person3.action((x, y) -> (x + y));

        // 리턴문이 하나만 있을 경우(메소드 호출)
        // person.action((x, y) -> {
        //});
        person3.action((x, y) -> sum(x, y));
    }

    public static double sum(double x, double y) {
        return (x + y);
    }

    public void MethodReferenceExample() {
        Person3 person3 = new Person3();

        // 정적 메소드일 경우
        // 람다식
        // person.action((x ,y) -> Computer.staticMethod(x, y));
        // 메소드 참조
        person3.action((Computer :: staticMethod ));

        // 인스턴스 메소드일 경우
        Computer com = new Computer();
        // 람다식
        // person3.action((x, y) -> com.instanceMethod(x, y));
        // 메소드 참조
        person3.action(com :: instanceMethod );
    }
}
