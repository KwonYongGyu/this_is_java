package com.mjc813;

public class Chapter05 {
    // p.150
    public void ReferenceVariableCompareExample() {
        int[] arr1;    // 배열 변수 arr1 선언
        int[] arr2;    // 배열 변수 arr2 선언
        int[] arr3;    // 배열 변수 arr3 선언

        arr1 = new int[]{1, 2, 3,};  // 배열 { 1, 2, 3 }을 생성하고 arr1 변수에 대입
        arr2 = new int[]{1, 2, 3,};  // 배열 { 1, 2, 3 }을 생성하고 arr2 변수에 대입
        arr3 = arr2;    // 배열 변수 arr2의 값을 배열 변수 arr3에 대입

        System.out.println(arr1 == arr2);   // arr1과 arr2 변수가 같은 배열을 참조하는지 검사
        System.out.println(arr2 == arr3);   // arr2와 arr3 변수가 같은 배열을 참조하는지 검사
    }

    //p.153
    public void NullPointerExceptionExample() {
        int[] intArray = null;
        // intArray[0] = 10; //NullPointerException
        // intArray가 참조하는 배열 객체가 없기때문에 10을 저장할 수 없다.

        String str = null;
        // System.out.println("총 문자 수: " + str.length());//NullPointerException
        // str 변수가 참조하는 String 객체가 없으므로 문자열의 길이를 구할 수 없다.
    }

    // p.155
    public void GarbageObjectExample() {
        String hobby = "여행";
        hobby = null;   // "여행"에 해당하는 String 객체를 쓰레기로 만듦

        String kind1 = "자동차";

        String kind2 = kind1;   //kind1 변수에 저장되어 있는 번지를 kind2변수에 대입
        kind1 = null;    //"자동차"에 해당하는 String 객체 쓰레기가 아님
        System.out.println("kind2: " + kind2);
    }

    // p.158
    public void EqualsExample() {
        String strVar1 = "홍길동";
        String strVar2 = "홍길동";
        // 자바는 문자열 리터럴이 동일하다면 String 객체를 공유하도록 설계되어 있다.
        // "홍길동"으로 같은 리터럴을 공유하기에 strVar1, strVar2는 객체를 공유한다.

        if (strVar1 == strVar2) {
            System.out.println("strVar1과 strVar2는 참조가 같음");
        } else {
            System.out.println("strVar1과 strVar2는 참조가 다름");
        }

        if (strVar1.equals(strVar2)) {
            System.out.println("strVar1과 strVar2는 문자열일 같음");
        }
        String strVar3 = new String("홍길동");
        String strVar4 = new String("홍길동");
        // "홍길동"으로 같은 리터럴을 가지지만 둘을 다른 주소를 가진다.
        // new 연산자로 직접 String 객체를 생성하고 대입해서 둘은 서로 다른 객체를 가진다.

        if (strVar3 == strVar4) {
            System.out.println("strVar3과 strVar4는 참조가 같음");
        } else {
            System.out.println("strVar3과 strVar4는 참조가 다름");
        }

        if (strVar3.equals(strVar4)) {
            System.out.println("strVar3과 strVar4는 문자열이 같음");
        }
    }

    // p.159
    public void EmptyStringExample() {
        String hobby = "";
        if (hobby.equals("")) {
            System.out.println("hobby 변수가 참조하는 String 객체는 빈 문자열");
        }
    }

    // p.160
    public void CharAtExample() {
        String ssn = "95062410123";
        char sex = ssn.charAt(6);
        switch (sex) {
            case '1':
            case '3':
                System.out.println("남자입니다.");
                break;
            case '2':
            case '4':
                System.out.println("여자입니다.");
                break;
        }
    }

    // p.161
    public void LengthExample() {
        String ssn = "9506241230123";
        int length = ssn.length();
        if (length == 13) {
            System.out.println("주민등록번호 자릿수가 맞습니다.");
        } else {
            System.out.println("주민등록번호 자릿수가 틀립니다.");
        }
    }

    // p.162
    public void ReplaceExample() {
        String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 String입니다.";
        String newStr = oldStr.replace("자바", "JAVA");
    // 자바에서 문자열은 불변하므로 .replace를 이용해 완전히 새로운 문자열 객체를 반환
        System.out.println(oldStr); // 원본 문자열
        System.out.println(newStr); // 새로운 문자열 객체
    }

    // p.163
    public void SubStringExample() {
        String ssn = "880815-1234567";

        String firstNum = ssn.substring(0, 6);
        System.out.println(firstNum);

        String secondNum = ssn.substring(7);
        System.out.println(secondNum);
    }

    // p.165
    public void IndexOfContainsExample() {
        String subject = "자바 프로그래밍";
    // indexOf 방식은 리턴된 숫자값이 -1이 아닐때 (0,1,2.... 등 위치값이 나올 때)
        int location = subject.indexOf("프로그래밍");
        // 정수를 리턴하기에 location을 정수가 아닌 다른 값으로 설정하면 오류발생
        System.out.println(location); // 인덱스 위치 3
        String substring = subject.substring(location);
        System.out.println(substring);

        location = subject.indexOf("자바");   // 인덱스 0번 리턴
        //자바랑 관련이 없으면 -1 리턴
        if (location != -1) { // -1 이 아니면 즉 관련이 있으면
            System.out.println("자바와 관련된 책이군요.");
        } else {
            System.out.println("자바와 관련 없는 책이군요");
        }

        // contains 방식은 리턴된 결과값이 true일 때
        boolean result = subject.contains("자바"); // subject에 자바가 포함되어 있는가?
        if (result) {
            System.out.println("자바와 관련된 책이군요");
        } else {
            System.out.println("자바와 관련 없는 책이군요");
        }
    }
}
