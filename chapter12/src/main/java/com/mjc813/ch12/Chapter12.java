package com.mjc813.ch12;

import com.mjc813.ch15set.Member;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.*;
import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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

    public void BoxingUnBoxingExample(){
        //Boxing
        Integer obj = 100;
        System.out.println("value: " + obj.intValue());

        //Unboxing
        int value = obj;
        System.out.println("value: " + value);

        // 연산 시 Unboxing
        int result = obj + 100;
        System.out.println("result: " + result);
    }

    public void ValueCompareExample(){
        // -128 ~ 127 초과값일 경우
        Integer obj1 = 300;
        Integer obj2 = 300;
        System.out.println("==: " + (obj1==obj2));
        System.out.println("equals(): " + obj1.equals(obj2));
        System.out.println();

        // -128 ~ 127 범위값일 경우
        Integer obj3 = 10;
        Integer obj4 = 10;
        System.out.println("==: " + (obj3 == obj4));
        System.out.println("equals: " + obj3.equals(obj4));
    }

    public void MathExample(){
        // 큰 정수 또는 작은 정수 얻기
        double v1 = Math.ceil(5.3);
        double v2 = Math.floor(5.3);
        System.out.println("v1=" + v1);
        System.out.println("v2=" + v2);

        // 큰값 또는 작은값 얻기
        long v3 = Math.max(3, 7);
        long v4 = Math.min(3, 7);
        System.out.println("v3=" + v3);
        System.out.println("v4=" + v4);

        // 소수 이하 두 자리 얻기
        double value = 12.3456;
        double temp1 = value * 100;
        long temp2 = Math.round(temp1);
        double v5 = temp2 / 100.0;
        System.out.println("v5=" + v5);
    }

    public void RandomExample(){
        // 선택 번호
        int[] selectNumber = new int[6];
        Random random = new Random(3);
        System.out.print("선택번호: " );
        for(int i =0; i<6; i++){
            selectNumber[i] = random.nextInt(45) + 1;
            System.out.print(selectNumber[i] + " ");
        }
        System.out.println();

        // 당첨 번호
        int[] winningNumber = new int[6];
        random = new Random(5);
        System.out.print("당첨번호: ");
        for(int i = 0; i < 6 ; i++){
            winningNumber[i] = random.nextInt(45) + 1;
            System.out.print(winningNumber[i] + " ");
        }
        System.out.println();

        // 당첨여부
        Arrays.sort(selectNumber);
        Arrays.sort(winningNumber);
        boolean result = Arrays.equals(selectNumber, winningNumber);
        System.out.print("당첨여부: ");
        if(result) {
            System.out.println("1등에 당첨되셨습니다.");
        } else {
            System.out.println("당첨되지 않았습니다.");
        }
    }

    public void DateExample(){
        Date now = new Date();
        String strNow1 = now.toString();
        System.out.println(strNow1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String strNow2 = sdf.format(now);
        System.out.println(strNow2);
    }

    public void CalendarExample(){
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);

        int week = now.get(Calendar.DAY_OF_WEEK);
        String strWeek = null;
        switch(week) {
            case Calendar.MONDAY:
                strWeek = "월";
                break;
            case Calendar.TUESDAY:
                strWeek = "화";
                break;
            case Calendar.WEDNESDAY:
                strWeek = "수";
                break;
            case Calendar.THURSDAY:
                strWeek = "목";
                break;
            case Calendar.FRIDAY:
                strWeek = "금";
                break;
            case Calendar.SATURDAY:
                strWeek = "토";
                break;
            default:
                strWeek = "일";
        }

        int amPm = now.get(Calendar.AM_PM);
        String strAmPm = null;
        if(amPm == Calendar.AM) {
            strAmPm = "오전";
        } else {
            strAmPm = "오후";
        }

        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        System.out.print(year + "년 ");
        System.out.print(month + "월 ");
        System.out.println(day + "일 ");
        System.out.print(strWeek + "요일 ");
        System.out.println(strAmPm + " ");
        System.out.print(hour + "시 ");
        System.out.print(minute + "분 ");
        System.out.println(second + "초 ");
    }

    public void LosAngelesExample(){
        TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
        Calendar now = Calendar.getInstance( timeZone );

        int amPm = now.get(Calendar.AM_PM);
        String strAmPm = null;
        if(amPm == Calendar.AM) {
            strAmPm = "오전";
        } else {
            strAmPm = "오후";
        }
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        System.out.print(strAmPm + " ");
        System.out.print(hour + "시 ");
        System.out.print(minute + "분 ");
        System.out.println(second + "초 ");
    }

    public void DateTimeOperationExample(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
        System.out.println("현재 시간: " + now.format(dtf));

        LocalDateTime result1 = now.plusYears(1);
        System.out.println("1년 덧셈: " + result1.format(dtf));

        LocalDateTime result2 = now.minusMonths(2);
        System.out.println("2월 뺄셈: " + result2.format(dtf));

        LocalDateTime result3 = now.plusDays(7);
        System.out.println("7월 덧셈: " + result3.format(dtf));
    }

    public void DateTimeCompareExample(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");

        LocalDateTime startDateTime = LocalDateTime.of(2021,    1, 1, 0, 0, 0);
        System.out.println("시작일: " + startDateTime.format(dtf));

        LocalDateTime endDateTime = LocalDateTime.of(2021,  12, 31, 0, 0, 0);
        System.out.println("종료일: " + endDateTime.format(dtf));

        if(startDateTime.isBefore(endDateTime)) {
            System.out.println("진행 중입니다.");
        } else if(startDateTime.isEqual(endDateTime)) {
            System.out.println("종료합니다.");
        } else if (startDateTime.isAfter(endDateTime)) {
            System.out.println("종료했습니다.");
        }

        long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS);
        long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS);
        long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
        long remainHour = startDateTime.until(endDateTime, ChronoUnit.HOURS);
        long remainMinute = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
        long remainSecond = startDateTime.until(endDateTime, ChronoUnit.SECONDS);
        System.out.println("남은 해: " + remainYear);
        System.out.println("남은 월: " + remainMonth);
        System.out.println("남은 일: " + remainDay);
        System.out.println("남은 시간: " + remainHour);
        System.out.println("남은 분: " + remainMinute);
        System.out.println("남은 초: " + remainSecond);

    }

    public void DecimalFormatExample(){
        double num = 1234567.89;

        DecimalFormat df;

        // 정수 자리까지 표기
        df = new DecimalFormat("#,###");
        System.out.println( df.format(num) );

        // 무조건 소수 첫째 자리까지 표기
        df = new DecimalFormat("#,###.0");
        System.out.println( df.format(num) );

    }

    public void SimpleDateFormatExample(){
         Date now = new Date();

         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         System.out.println( sdf.format(now) );

         sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
         System.out.println( sdf.format(now) );

         sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
         System.out.println( sdf.format(now) );

         sdf = new SimpleDateFormat("오늘은 E요일");
         System.out.println( sdf.format(now) );

        sdf = new SimpleDateFormat("오늘은 D번째 날");
        System.out.println( sdf.format(now) );

        sdf = new SimpleDateFormat("오늘은 d번째 날");
        System.out.println( sdf.format(now) );
    }

    public void GetClassExample(){
        // how1
        Class clazz = Car.class;

        System.out.println("패키지: " + clazz.getPackage().getName());
        System.out.println("클래스 간단 이름: " + clazz.getSimpleName());
        System.out.println("클래스 전체 이름: " + clazz.getName());
    }

//    public void ReflectionExample throws Exception(){

//    public void GetResourceExample(){
//        Class clazz = Car.class;
//
//        String photo1Path = clazz.getResource("photo1.jpg").getPath();
//        String photo2Path = clazz.getResource("images/photo2.jpg").getPath();
//
//        System.out.println(photo1Path);
//        System.out.println(photo2Path);
//    }


}
