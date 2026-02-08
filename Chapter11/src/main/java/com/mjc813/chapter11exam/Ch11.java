package com.mjc813.chapter11exam;

import javax.accessibility.AccessibleContext;

public class Ch11 {
    // 문자열 길이를 출력하는 메서드
    public void printLength1(String data) {
        try {
            int result = data.length(); // data가 null일 경우 NullPointerException 발생
            System.out.println("문자 수: " + result);
        } catch (NullPointerException e) {
            // 예외가 발생했을 때 처리하는 코드
            System.err.println("에러 발생: 데이터를 확인하세요. (null 전달됨)");
        } finally {
            System.out.println("[마무리 실행] 메서드 종료 시도\n");
        }
    }

    // 예제를 실행하기 위한 진입점 메서드
    public void runExample1() {
        System.out.println("[프로그램 시작]\n");

        printLength1("ThisIsJava");
        printLength1(null); // 여기서 예외가 발생하지만 try-catch로 인해 프로그램은 계속됩니다.

        System.out.println("[프로그램 종료]");
    }

    public void printLength2(String data) {
        try {
            int result = data.length(); // data가 null일 경우 NullPointerException 발생
            System.out.println("문자 수: " + result);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); //(1)
            //System.out.println(e.toString()); //(2);  예외정보를 얻는 3가지 방법
            //e.printStackTrace();  //(3);
        } finally {
            System.out.println("[마무리 실행]\n");
        }
    }

    public void runExample2() {
        System.out.println("[프로그램 시작]");
        printLength2("ThisIsJava");
        printLength2(null);
        System.out.println("[프로그램 종료]");
    }

    //
//    public void printLength3(String data){
//        try{
//            int result = data.length(); // data가 null일 경우 NullPointerException
//            System.out.println("문자 수: " + result);
//        }  catch (NullPointerException e ) {
//            System.out.println(e.getMessage()); //(1)
//            //System.out.println(e.toString()); //(2);  예외정보를 얻는 3가지 방법
//            //e.printStackTrace();  //(3);
//        } finally {
//            System.out.println("[마무리 실행]\n");
//        }
//    }
//    public void runExample3(){
//        System.out.println("[프로그램 시작]");
//        printLength2("ThisIsJava");
//        printLength2(null);
//        System.out.println("[프로그램 종료]");
//    }
    public void runExample3() {
        try {
            Class.forName("java.lang.String");  // ClassNotFoundException 발생 가능 코드
            System.out.println("java.lang.String 클래스가 존재합니다.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            Class.forName("java.lang.Stirng2"); // ClassNotFoundException 발생 가능 코드
            System.out.println("java.lang.String2 클래스가 존재합니다.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 예외 종류에 따른 처리
    public void runExample4() {
        String[] array = {"100", "1oo"};

        for (int i = 0; i < array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("숫자로 변환할 수 없음: " + e.getMessage());
            } catch (Exception e) {
                // 상위 예외 클래스는 아래쪽에 작성 부모는 마지막에 와야 한다. 부모가 자식보다 먼저 위치하면 자식은 실행하지 않고 넘어감
                System.out.println("실행에 문제가 있습니다.");
            }
        }
    }

    // 두개 이상의 예외를 하나의 catch 블록으로 동일하게 예외 처리하는 경우
    public void runExample5() {
        String[] array = {"100", "1oo", null, "200"};

        for (int i = 0; i < array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            } catch (NullPointerException | NumberFormatException e) {   // 2가지 예외를 동일하게 처리
                System.out.println("데이터에 문제가 있음: " + e.getMessage());
            }
        }
    }

    // 리소스 자동 닫기 (Try-with-resources)
    public void runExample6() {
        System.out.println("--- runExample6: 리소스 자동 닫기 ---");

        // 패턴 1: 정상 실행 및 자동 닫기
        try (MyResource res = new MyResource("A")) {
            String data = res.read1();
            int value = Integer.parseInt(data);
            System.out.println("변환된 값: " + value);
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        // 패턴 2: 예외 발생 시에도 자동 닫기
        try (MyResource res = new MyResource("A")) {
            String data = res.read2(); // "abc" 반환 -> NumberFormatException 발생
            int value = Integer.parseInt(data);
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        // 패턴 3: 외부 리소스 변수를 try에 넣기 (Java 9 이상)
        MyResource res1 = new MyResource("A");
        MyResource res2 = new MyResource("B");
        try (res1; res2) {
            String data1 = res1.read1();
            String data2 = res2.read2();
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }
    }
    // 예외 떠넘기기
    public void runExample7(){
        try{
            findClass();
        } catch(ClassNotFoundException e) { // 호출한 곳에서 예외 처리
            System.out.println("예외 처리: " + e.toString());
        }
    }
    public static void findClass() throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    }
    // 사용자 정의 예외
    public void runExample8(){
        Account account = new Account();
        // 예금하기
        account.deposit(1000);
        System.out.println("예금액: " + account.getBalance());

        // 출금하기
        try {
            account.withdraw(30000);
        } catch (InsufficientException e) { // 예외 처리 코드와 함께 withdraw() 메소드 호출
            String message = e.getMessage();
            System.out.println(message);
        }
    }

}
