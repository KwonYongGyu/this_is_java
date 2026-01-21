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
            System.out.print("arr1[" + i + "] : " + arr1[i] + ", ");
        }
        System.out.println();
        // 배열 항목의 값 변경
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;
        // 배열 항목의 변경 값 출력
        for (int i = 0; i < 3; i++) {
            System.out.print("arr1[" + i + "] : " + arr1[i] + ", ");
        }
        System.out.print("\n");

        // 배열 변수 선언과 배열 생성
        double[] arr2 = new double[3];
        // 배열 항목의 초기값 출력
        for (int i = 0; i < 3; i++) {
            System.out.print("arr2[" + i + "] : " + arr2[i] + ", ");
        }
        System.out.println();
        // 배열 항목의 값 변경
        arr2[0] = 0.1;
        arr2[1] = 0.2;
        arr2[2] = 0.3;
        // 배열 항목의 변경 값 추력
        for (int i = 0; i < 3; i++) {
            System.out.print("arr2[" + i + "] : " + arr2[i] + ", ");
        }
        System.out.print("\n");

        // 배열 변수 선언과 배열 생성
        String[] arr3 = new String[3];
        // 배열 항목의 초기값 출력
        for (int i = 0; i < 3; i++) {
            System.out.print("arr3[" + i + "] : " + arr3[i] + ", ");
        }
        System.out.println();
        // 배열 항목의 값 변경
        arr3[0] = "1월";
        arr3[1] = "2월";
        arr3[2] = "3월";
        // 배열 항목의 변경 값 추력
        for (int i = 0; i < 3; i++) {
            System.out.print("arr3[" + i + "] : " + arr3[i] + ", ");
        }
    }

    // p.177
    public void ArrayLengthExample() {
        // 배열 변수 선언과 배열 대입
        int[] scores = {84, 90, 96};

        // 배열 항목의 총합 구하기
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        System.out.println("총합: " + sum);

        // 배열 항목의 평균 구하기
        double avg = (double) sum / scores.length;
        System.out.println("평균 : " + avg);
    }

    // p.180
    public void MultidimensionalArrayByValue() {
        // 2차원 배열 생성
        int[][] scores = {
                {80, 90, 96},
                {76, 88}
        };
        // 배열의 길이
        System.out.println("1차원 배열 길이(반의 수): " + scores.length);
        System.out.println("2차원 배열 길이(첫 번째 반의 학생 수): " + scores[0].length);
        System.out.println("2차원 배열 길이(두 번째 반의 학생 수): " + scores[1].length);

        // 첫 번재 반의 세 번째 학생의 점수 읽기
        System.out.println("scroes[0][2]: " + scores[0][2]);

        // 두 번째 반의 두 번재 학생의 점수 읽기
        System.out.println("scores[1][1]: " + scores[1][1]);

        // 첫 번째 반의 평균 점수 구하기
        int class1Sum = 0;
        for (int i = 0; i < scores[0].length; i++) {
            class1Sum += scores[0][i];
        }
        double class1Avg = (double) class1Sum / scores[0].length;
        System.out.println("첫 번째 반의 평균 점수: " + class1Avg);

        // 두 번재 반의 평균 점수 구하기
        int class2Sum = 0;
        for (int i = 0; i < scores[1].length; i++) {
            class2Sum += scores[1][i];
        }
        double class2Avg = (double) class2Sum / scores[1].length;
        System.out.println("두 번째 반의 평균 점수: " + class2Avg);

        // 전체 학생의 평균 점수 구하기
        int totalStudent = 0;
        int totalSum = 0;
        for (int i = 0; i < scores.length; i++) {  // 반의 수만큼 반복
            totalStudent += scores[i].length;   // 반의 학생 수 합산
            for (int k = 0; k < scores[i].length; k++) {  // 해당 반의 학생 수만큼 반복
                totalSum += scores[i][k];   // 학생 점수 합산
            }
        }
        double totalAvg = (double) totalSum / totalStudent;
        System.out.println("전체 학생의 평균 점수: " + totalAvg);

    }

    // p.184
    public void MultidimensionalArrayByNewExample() {
        // 각 반의 학생수가 3명으로 동일할 경우 점수 저장을 위한 2차원 배열 생성
        int[][] mathScores = new int[2][3];
        // 배열 항목 초기값 출력
        for (int i = 0; i < mathScores.length; i++) { // 반의 수만큼 반복
            for (int k = 0; k < mathScores[i].length; k++) {   // 해당 반의 학생 수만큼 반복
                System.out.println("mathScores[" + i + "][" + k + "]: "
                        + mathScores[i][k]);
            }
        }
        System.out.println();
        // 배열 항목 값 변경
        mathScores[0][0] = 80;
        mathScores[0][1] = 83;
        mathScores[0][2] = 85;
        mathScores[1][0] = 86;
        mathScores[1][1] = 90;
        mathScores[1][2] = 92;
        // 전체 학생의 수학 평균 구하기
        int totalStudent = 0;
        int totalMathSum = 0;
        for (int i = 0; i < mathScores.length; i++) { // 반의 수만큼 반복
            totalStudent += mathScores[i].length; // 반의 학생 수 합산
            for (int k = 0; k < mathScores[i].length; k++) {   // 해당 반의 학생 수만큼 반복
                totalMathSum += mathScores[i][k];   // 학생 점수 합산
            }
        }
        double totalMathAvg = (double) totalMathSum / totalStudent;
        System.out.println("전체 학생의 수학 평균 점수: " + totalMathAvg);
        System.out.println();

        // 각 반의 학생 수가 다를 경우 점수 저장을 위한 2차원 배열 생성
        int[][] englishscores = new int[2][];
        englishscores[0] = new int[2];
        englishscores[1] = new int[3];
        // 배열 항목 초기값 출력
        for (int i = 0; i < englishscores.length; i++) { // 반의 수만큼 바복
            for (int k = 0; k < englishscores[i].length; k++) {   // 해당 반의 학생 수 만큼 반복
                System.out.println("englishscores[" + i + "][" + k + "]: "
                        + englishscores[i][k]);
            }
        }
        System.out.println();
        // 배열 항목 값 변경
        englishscores[0][0] = 90;
        englishscores[0][1] = 91;
        englishscores[1][0] = 92;
        englishscores[1][1] = 93;
        englishscores[1][2] = 94;
        // 전체 학생의 영어 평균 구하기
        totalStudent = 0;
        int totalEnglishSum = 0;
        for (int i = 0; i < englishscores.length; i++) {  // 반의 수만큼 반복
            totalStudent += englishscores[i].length;    //  반의 학생 수 합산
            for (int k = 0; k < englishscores[i].length; k++) {  // 해당 반의 학생 수 만큼 반복
                totalEnglishSum += englishscores[i][k];  // 학생 점수 합산
            }
        }
        double totalEnglishAvg = (double) totalEnglishSum / totalStudent;
        System.out.println("전체 학생의 영어 평균 점수 : " + totalEnglishAvg);
    }

    // 10개의 boolean 값이 원소인 1차원 배열의 짝수번째 인덱스가 true 이고 다른 인덱스는 false 로 만들어서 출력하세요
    public void practice01() {
        boolean[] boolArray = new boolean[10];
        // 배열 초기값 출력
        for (int i = 0; i < boolArray.length; i++) {

            if (i % 2 == 0) {
                // 배열 항목의 값 변경
                boolArray[i] = true;
            }

            System.out.print(" " + boolArray[i]);

        }
        System.out.print("\n");
    }

    // 1-1 : 30개의 int 형 배열을 선언하고 모든 원소의 값을 인덱스 번호로 대입하세요.
    public void practice01_1() {
        int[] arr1 = new int[30];
        for (int i = 0; i < 30; i++) {
            arr1[i] = i;
        }

        System.out.print("arr1: " + java.util.Arrays.toString(arr1));
//        System.out.print(" " + arr1);
        System.out.print("\n");
    }

    //  1-2 : char 형 1차원배열을 선언하고 길이는 20개 입니다
    public void practice01_2() {
        char[] arr2 = new char[20];
    }

    // 1-3 : boolean 형 2차원 배열을 3행 4열 만들고 값을 true 로 모두 설정하세요.
    public void practice01_3() {
        boolean[][] boolArray = new boolean[3][4];
        for (int i = 0; i < boolArray.length; i++) {
            for (int k = 0; k < boolArray[i].length; k++) {
                boolArray[i][k] = true;
            }
        }
    }

    // 1-4 String 형 1차원 배열을 선언하고 길이는 50개 입니다. 모든 원소를 "empty" 로 설정하세요.
    public void practice01_4() {
        String[] str1 = new String[50];
        for (int i = 0; i < str1.length; i++) {
            str1[i] = "empty";
        }
    }

    // 2번 : 0,1 로 이루어진 2차원 직사각형 배열이 있습니다. 0의 갯수와 1의 갯수를 출력하세요
    public void practice02() {
        int[][] intDemention2 = {
                {0, 0, 1, 1, 0, 0}, {1, 0, 0, 1, 0, 0}
                , {0, 1, 0, 1, 0, 0}, {0, 0, 1, 1, 0, 1}
                , {1, 0, 0, 0, 1, 0}
        };
        int totalnumber0 = 0;
        int totalnumber1 = 0;
        for (int i = 0; i < intDemention2.length; i++) {
            for (int k = 0; k < intDemention2[i].length; k++) {
                if (intDemention2[i][k] == 0) {
                    totalnumber0 += 1;
                } else {
                    totalnumber1 += 1;
                }
            }
        }
        System.out.print("0인 원소의 개수: " + totalnumber0 + " \t" + "1인 원소의 개수: " + totalnumber1);
        System.out.print("\n");
    }


    // 2번 : 0,1 로 이루어진 2차원 직사각형 배열이 있습니다. 0의 갯수와 1의 갯수를 출력하세요
    public void practice02_1() {
        int[][] intDemention3 = {
                {1, 0, 1, 0, 0, 1}
                , {1, 0, 1, 1, 0, 1}
                , {0, 1, 0, 1, 0, 0}
                , {1, 0, 0, 1, 0, 1}
                , {1, 0, 1, 0, 0, 1}
        };
        int totalnumber0 = 0;
        int totalnumber1 = 0;
        for (int i = 0; i < intDemention3.length; i++) {
            for (int k = 0; k < intDemention3[i].length; k++) {
                if (intDemention3[i][k] == 0) {
                    totalnumber0 += 1;
                } else {
                    totalnumber1 += 1;
                }
            }
        }
        System.out.print("0인 원소의 개수: " + totalnumber0 + " \t" + "1인 원소의 개수: " + totalnumber1);
        System.out.print("\n");
    }
    // 3번 : 입력이 아래와 같을때 출력을 아래와 같이 만드세요.
    //입력 =>
    //	char[][] chInput = {
    //		{'*', '*', '*', '*', ' '},
    //		{'*', '*', ' ', ' ', ' '},
    //		{'*', ' ', '*', '*', '*'}
    //	};
    //	****
    //	**
    //	* ***

    public void practice03() {
        char[][] chInput = {
                {'*', ' ', '*', '*', ' '}
                , {'*', '*', ' ', ' ', ' '}
                , {'*', ' ', '*', ' ', '*'}
                , {' ', '*', '*', ' ', '*'}
                , {'*', ' ', '*', ' ', '*'}
                , {' ', ' ', '*', '*', '*'}
        };
        // 행열을 바꿔서 출력
        int i = chInput.length;
        int k = chInput[0].length;
        char[][] chOutput = new char[k][i];
        for (i = 0; i < chInput.length; i++) {
            for (k = 0; k < chInput[i].length; k++) {
                chOutput[k][i] = chInput[i][k];
            }
        }
        // 출력은 따로 for문을 새로 만들어 주는게 안전하다.
        System.out.println("출력배열입니다.");
        for (i = 0; i < chOutput.length; i++) {
            for (k = 0; k < chOutput[i].length; k++) {
                System.out.printf(" " + chOutput[i][k]);
            }
            System.out.println();
        }
    }

    // 과제 3 : 배열 숙성 과제
    // 1-1 : 1차원 배열 double[] dArray 갯수 25개 배열을 생성한다.
    public void practice01_5() {
        double[] dArray = new double[25];
        int i = 0;
        for (i = 0; i < dArray.length; i++) {
            dArray[i] = (double) (Math.random() * 99.99999) + 1;
        }
        //  1-2 : 1차원 배열 int[] nArray 갯수 25개 배열을 생성한다.
        int[] nArray = new int[dArray.length];
        int totalSum = 0;
        int totalAvg = 0;
        for (i = 0; i < nArray.length; i++) {
            nArray[i] = (int) dArray[i];
            totalSum += nArray[i];
            totalAvg = totalSum / nArray.length;
        }

        System.out.print("합: " + totalSum + "\t" + "평균: " + totalAvg + "\n");
        // 1-3 : 1차원 배열 String[] strArray 갯수 25개 배열을 생성한다.
        //		이 배열의 원소는 dArray원소의 값 => nArray원소의 값을 문자열로 합쳐서 저장한다.
        //		예 : "0.983723 => 0", "76.56734005613602345 => 76"
        //		strArray 배열 원소 25개를 출력해보자
        String[] strArray = new String[dArray.length];
        for (i = 0; i < strArray.length; i++) {
            strArray[i] = dArray[i] + " => "+ nArray[i];
        }
        System.out.println("strArray 배열 원소: ");
        for (i = 0; i < strArray.length; i++) {

            System.out.printf(" " + strArray[i] +"\n");

        }
    }

    //2-1 :
    //		입력 => 숫자를 입력 받는다. 예를 들어 number 가 3이다.
    //		2차원 배열 int[][] nArray = new int[number][number]; 배열을 생성한다.
    //		for 문을 이용하여서 원소에는 출력과 같이 되도록 숫자를 각 원소에 대입한다.
    public void practice01_6(){
        int number = 0;
        int[][] nArray = new int[number][number];
        for(int i = 0; i< nArray.length; i++){
            for(int k=0; k<nArray[i].length; k++){
                nArray[i][k] = i + k + 1;   // 1부터 시작

            }
            System.out.println();
        }
        System.out.println("--------------------------");

    }
}
