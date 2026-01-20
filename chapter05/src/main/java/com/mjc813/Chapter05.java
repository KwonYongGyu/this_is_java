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

    // p.165
    public void SplitExample() {
        String board = "1,자바 학습, 참조 타입 String을 학습합니다,홍길동";

        // 문자열 분리
        String[] tokens = board.split(",");

        // 인덱스별로 읽기
        System.out.println("번호: " + tokens[0]);
        System.out.println("제목: " + tokens[1]);
        System.out.println("내용: " + tokens[2]);
        System.out.println("성명: " + tokens[3]);

        // for 문을 이용한 읽기
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }
    }

    // p.170
    public void ArrayCreateByValueListExample1() {
        // 배열 변수 선언과 배열 생성
        String[] season = {"Spring", "Summer", "Fail", "Winter"};

        // 배열의 항목값 읽기
        System.out.println("season[0] : " + season[0]);
        System.out.println("season[1] : " + season[1]);
        System.out.println("season[2] : " + season[2]);
        System.out.println("season[3] : " + season[3]);

        // 인덱스 1번 항목의 값 변경
        season[1] = "여름";
        System.out.println("season[1] : " + season[1]);
        System.out.println();

        // 배열 변수 선언과 배열 생성
        int[] scores = {83, 90, 87};

        // 총합과 평균 구하기
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += scores[i];
        }
        System.out.println("총합 : " + sum);
        double avg = (double) sum / 3;
        System.out.println("평균 : " + avg);
    }

    // p.172
    public void ArrayCreateByValueListExample2() {
        // 배열 변수 선언
        int[] scores;

        // 배열 변수에 배열을 대입
        scores = new int[]{83, 90, 87};
        // 배열 항목의 총합을 구하고 출력
        int sum1 = 0;
        for (int i = 0; i < 3; i++) {
            sum1 += scores[i];
        }
        System.out.println("총합 : " + sum1);

        // 배열을 매개값으로 주고, printItem() 메소드 호출
        printItem(new int[]{83, 90, 87});

    }

    // printItem() 메소드 선언
    public static void printItem(int[] scores) {
        // 매개변수가 참조하는 배열의 항목을 출력
        for (int i = 0; i < 3; i++) {
            System.out.println("Score[" + i + "]: " + scores[i]);
        }
    }

    // p.175
    public void ArrayCreateByNewExample() {
        // 배열 변수 선언과 배열 생성
        int[] arr1 = new int[3];
        // 배열 항목의 초기값 출력
        for (int i = 0; i < 3; i++) {
            System.out.println("arr1[" + i + "] : " + arr1[i] + ", ");
        }
        System.out.println();
        // 배열 항목의 값 변경
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;
        // 배열 항목의 변경 값 출력
        for (int i = 0; i < 3; i++) {
            System.out.println("arr1[" + i + "] : " + arr1[i] + ", ");
        }
        System.out.println("\n");

        // 배열 변수 선언과 배열 생성
        double[] arr2 = new double[3];
        // 배열 항목의 초기값 출력
        for (int i = 0; i < 3; i++) {
            System.out.println("arr2[" + i + "] : " + arr2[i] + ", ");
        }
        System.out.println();
        // 배열 항목의 값 변경
        arr2[0] = 0.1;
        arr2[1] = 0.2;
        arr2[2] = 0.3;
        // 배열 항목의 변경 값 추력
        for (int i = 0; i < 3; i++) {
            System.out.println("arr2[" + i + "] : " + arr2[i] + ", ");
        }
        System.out.println("\n");

        // 배열 변수 선언과 배열 생성
        String[] arr3 = new String[3];
        // 배열 항목의 초기값 출력
        for (int i = 0; i < 3; i++) {
            System.out.println("arr3[" + i + "] : " + arr3[i] + ", ");
        }
        System.out.println();
        // 배열 항목의 값 변경
        arr3[0] = "1월";
        arr3[1] = "2월";
        arr3[2] = "3월";
        // 배열 항목의 변경 값 추력
        for (int i = 0; i < 3; i++) {
            System.out.println("arr3[" + i + "] : " + arr3[i] + ", ");
        }
    }
    // p.177
    public void ArrayLengthExample(){
        // 배열 변수 선언과 배열 대입
        int[] scores = { 84, 90, 96 };

        // 배열 항목의 총합 구하기
        int sum = 0;
        for(int i=0; i<scores.length; i++){
            sum += scores[i];
        }
        System.out.println("총합: " + sum);

        // 배열 항목의 평균 구하기
        double avg = (double) sum / scores.length;
        System.out.println("평균 : " + avg);
    }
    // p.180
    public void MultidimensionalArrayByValue(){
        // 2차원 배열 생성
        int[][] scores = {
                { 80, 90, 96 },
                { 76, 88 }
        };
        // 배열의 길이
        System.out.println("1차원 배열 길이(반의 수): " + scores.length);
        System.out.println("2차원 배열 길이(첫 번째 반의 학생 수): " + scores[0].length);
        System.out.println("2차원 배열 길이(두 번째 반의 학생 수): " + scores[1].length);

        // 첫 번재 반의 세 번째 학생의 점수 읽기
        System.out.println("scroes[0][2]: " + scores[0][2]);

        // 두 번째 반의 두 번재 학생의 점수 읽기
        System.out.println("scores[1][1]" + scores[1][1]);

        // 첫 번째 반의 평균 점수 구하기
        int class1Sum = 0;
        for(int i=0; i<scores[0].length;i++){
            class1Sum +=scores[0][i];
        }
        double class1Avg = (double) class1Sum / scores[0].length;
        System.out.println("첫 번째 반의 평균 점수: " + class1Avg);

        // 두 번재 반의 평균 점수 구하기
        int class2Sum = 0;
        for(int i=0; i<scores[1].length;i++){
            class2Sum +=scores[1][i];
        }
        double class2Avg = (double) class2Sum / scores[1].length;
        System.out.println("두 번째 반의 평균 점수: " + class2Avg);

        // 전체 학생의 평균 점수 구하기
        int totalStudent = 0;
        int totalSum = 0;
        for(int i=0; i<scores.length;i++){  // 반의 수만큼 반복
            totalStudent += scores[i].length;   // 반의 학생 수 합산
        }

    }




}
