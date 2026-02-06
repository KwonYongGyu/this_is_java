package com.mjc813.ch12;

import com.mjc813.ch15set.Member;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Chapter12 {
    public void EqualsExample() {
        Member1 obj1 = new Member1("blue");
        Member1 obj2 = new Member1("blue");
        Member1 obj3 = new Member1("red");

        if (obj1.equals(obj2)) {
            System.out.println("obj1과 obj2는 동등합니다.");
        } else {
            System.out.println("obj1과 obj2는 동등하지 않습니다.");
        }

        if (obj1.equals(obj3)) {
            System.out.println("obj1과 obj3은 동등합니다.");
        } else {
            System.out.println("obj1과 obj3은 동등하지 않습니다.");
        }
    }

    public void HashCodeExample() {
        Student s1 = new Student(1, "홍길동");
        Student s2 = new Student(1, "홍길동");

        if (s1.hashCode() == s2.hashCode()) { // 해시코드가 동일한지 검사
            if (s1.equals(s2)) {  // 데이터가 동일한지 검사
                System.out.println("동등 객체입니다.");
            } else {
                System.out.println("데이터가 다르므로 동등 객체가 아닙니다.");
            }
        } else {
            System.out.println("해시코드가 다르므로 동등 객체가 아닙니다.");
        }
    }

    public void HashSetExample() {
        HashSet hashSet = new HashSet();    // HashSet 컬렉션 생성

        Student s1 = new Student(1, "홍길동");
        hashSet.add(s1);        // HashSet에 Student 객체 저장
        System.out.println("저장된 객체 수: " + hashSet.size());

        Student s2 = new Student(1, "홍길동");
        hashSet.add(s2);        // HashSet에 Student 객체 저장
        System.out.println("저장된 객체 수: " + hashSet.size());

        Student s3 = new Student(2, "홍길동");
        hashSet.add(s3);        // HashSet에 Student 객체 저장
        System.out.println("저장된 객체 수: " + hashSet.size());
    }

    public void ToStringExample() {
        SmartPhone myPhone = new SmartPhone("삼성전자", "안드로이드");

        String strObj = myPhone.toString(); // toString() 메소드 호출
        System.out.println(strObj);

        System.out.println(myPhone); // toString() 메소드 호출

    }
    // 레코드 선언
    public void RecordExample() {
        Member2 m = new Member2("winter", "눈송이", 25);
        System.out.println(m.id()); // 68번부터 70번째 줄까지 Getter 메소드 호출
        System.out.println(m.name());
        System.out.println(m.age());
        System.out.println(m.toString());
        System.out.println();

        Member2 m1 = new Member2("winter", "눈송이", 25);
        Member2 m2 = new Member2("winter", "눈송이", 25);
        System.out.println("m1.hashCode(): " + m1.hashCode());
        System.out.println("m2.hashCode(): " + m2.hashCode());
        System.out.println("m1.equals(m2): " + m1.equals(m2));  // 동등 비교
    }

    // 콘솔 출력
    public void ErrExample() {
        try {
            int value = Integer.parseInt("1oo");    // 오류 발생을 위해 100이 아닌 1oo를 입력
        } catch (NumberFormatException e) {
            System.err.println("[에러 내용]");
            System.err.println(e.getMessage());
        }
    }

    public void IntExample() throws IOException {
        int speed = 0;
        int keyCode = 0;

        while (true) {
            // Enter 키를 읽지 않았을 경우에만 실행
            if (keyCode != 13 && keyCode != 10) {
                if (keyCode == 49) { // 숫자 1 키를 읽었을 경우
                    speed++;
                } else if (keyCode == 50) { // 숫자 2 키를 읽었을 경우
                    speed--;

                } else if (keyCode == 51) { // 숫자 3 키를 읽었을 경우
                    break;
                }
                System.out.println("-------------------------------------");
                System.out.println("1. 종속 | 2. 감속 | 3. 중지");
                System.out.println("-------------------------------------");
                System.out.println("현재 속도= " + speed);
                System.out.println("선택: ");
            }
            // 키를 하나씩 읽음
            keyCode = System.in.read();
        }
        System.out.println("프로그램 종료");
    }
    // 프로세스 종료
    public void ExitExample(){
        for(int i = 0; i < 10; i++) {
            // i값 출력
            System.out.println(i);
            if(i == 5){
                // JVM 프로세스 종료
                System.out.println("프로세스 강제 종료");
                System.exit(0);
            }
        }
    }
    // 진행시간 읽기
    public void MeasureRunTimeExample(){
        long time1 = System.nanoTime();
        int sum = 0;
        for(int i = 0; i <= 1000000; i++){
            sum += i;
        }
        long time2 = System.nanoTime();

        System.out.println("1~1000000까지의 합: " + sum);
        // 프로그램 처리를 시작할 때 한 번, 끝날 때 한 번 읽어서 그차이를 구해 프로그램 처리 시간을 출력한다.
        System.out.println("계산에 " + (time2 - time1) + "나노초가 소요되었습니다.:");
    }
    // 시스템 프로퍼티 읽기
    public void GetPropertyExample(){
        // 운영체제와 사용자 정보 출력
        String osName = System.getProperty("os.name");
        String userName = System.getProperty("user.name");
        String userHome = System.getProperty("user.home");
        System.out.println(osName);
        System.out.println(userName);
        System.out.println(userHome);

        // 전체 키와 값을 출력
        System.out.println("--------------------------");
        System.out.println(" key:   value");
        System.out.println("--------------------------");
        Properties props = System.getProperties();
        Set keys = props.keySet();
        for(Object objKey : keys) {
            String key = (String) objKey;
            String value = System.getProperty(key);
            System.out.printf("%~40s: %\n", key, value);
        }

    }
    // 문자열을 byte 배열로 변환시키고 다시 문자열로 복원
    public void BytesToStringExample() throws UnsupportedEncodingException {
        String data ="자바";

        //String -> byte 배열(기본: UTF-8 인코딩)
        byte[] arr1 = data.getBytes();  // byte[] arr1 = data.getBytes("UTF-8");
        System.out.println("arr1: " + Arrays.toString(arr1));

        // byte 배열 ->  String(기본: UTF-8 디코딩)
        String str1 = new String(arr1); // String str1 = new String(arr1, "UTF-8");
        System.out.println("str1: " + str1);

        //String -> byte 배열(EUC-KR 인코딩)
        byte[] arr2 = data.getBytes("EUC-KR");
        System.out.println("arr2: " + Arrays.toString(arr2));

        //byte 배열 -> String(EUC-KR 디코딩)
        String str2 = new String(arr2, "EUC-KR");
        System.out.println("str2: " + str2);
    }

    public void StringBuilderExample(){
        String data = new StringBuilder() // 194부터 198까지 메소드 체이닝
                .append("DEF")
                .insert(0, "ABC")   // 0번째위치에 "ABC"문자열 추가
                .delete(3, 4)   // "ABCDEF"의 3부터 4번째 전까지 즉 D 삭제
                .toString();    // 완성된 문자열을 리턴
        System.out.println(data);
    }
    public void StringTokenizerExample(){
        String data1 = "홍길동&이수홍,박연수";
        String[] arr = data1.split("&|,");
        for(String token : arr){
            System.out.println(token);
        }
        System.out.println();

        String data2 = "홍길동/이수홍/박연수";
        StringTokenizer st = new StringTokenizer(data2, "/");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            System.out.println(token);
        }
    }
}
