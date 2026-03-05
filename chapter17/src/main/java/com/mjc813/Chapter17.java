package com.mjc813;

import java.util.ArrayList;
import java.util.List;

import com.mjc813.bookExample.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.IntStream;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


public class Chapter17 {
    public void StreamExample(){
        // Set 컬렉션 생성
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신용권");
        set.add("감자바");

        // Stream을 이용한 요소 반복 처리
        Stream<String> stream = set.stream();
        stream.forEach( name -> System.out.println(name));
    }

    public void ParallelStreamExample(){
        // List 컬렉션 생성
        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("신용권");
        list.add("감자바");
        list.add("람다식");
        list.add("박병렬");

        // 병렬 처리
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach( name -> {
            System.out.println( name + ": " + Thread.currentThread().getName());
        });

    }

    public void StreamPipeLineExample() {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        //방법1
        /*
        Stream<Student> studentStream = list.stream();
        // 중간 처리(학생 객체를 점수로 매핑)
        IntStream scoreStream = studentStream.mapToInt(student -> student.
                                getScore());
        // 최종 처리(평균 점수)
        double avg = scoreStream.average().getAsDouble();
         */

        //방법2
        double avg = list.stream()
                .mapToInt(student -> student.getScore())
                .average()
                .getAsDouble();

        System.out.println("평균 점수: " + avg);

    }

    public void StreamExample2() {
        // List 컬렉션 생성
        List<Product> list = new ArrayList<>();
        for(int i = 1; i <= 5; i++) {
            Product product = new Product(i, "상품" + i, "멋진 회사", (int)
                    (1000 * Math.random()));
            list.add(product);
        }

        // 객체 스트림 얻기
        Stream<Product> stream = list.stream();
        stream.forEach(p -> System.out.println(p));
    }

    public void StreamExample3() {
        String[] strArray = { "홍길동", "신용권", "김미나"};
        Stream<String> strStream = Arrays.stream(strArray);
        strStream.forEach(item -> System.out.print(item + ","));
        System.out.println();

        int[] intArray = { 1, 2, 3, 4, 5, 6 };
        IntStream intStream = Arrays.stream(intArray);
        intStream.forEach(item -> System.out.println(item + ","));
        System.out.println();
    }


    public static int sum;
    public void StreamExample4() {

        IntStream stream = IntStream.rangeClosed(1, 100);
        stream.forEach(a -> sum += a);
        System.out.println("총합: " + sum);
    }

    public void StreamExample5() throws Exception {
        Path path = Paths.get(StreamExample5.class.getResource("data.txt").toURI());
        Stream<String> stream = Files.lines(path, Charset.defaultCharset());
        stream.forEach(line -> System.out.println(line) );
        stream.close();
    }

    public void FilterExample() {
        // List 컬렉션 생성
        List<String> list = new ArrayList<>();
        list.add("홍길동");    list.add("신용권");
        list.add("감자바");    list.add("신용권");    list.add("신민철");

        // 중복 요소 제거
        list.stream()
                .distinct()
                .forEach(n -> System.out.println(n));
        System.out.println();

        // 신으로 시작하는 요소만 필터링
        list.stream()
                .filter(n -> n.startsWith("신"))
                // String의 startsWith() 메소드는 주어진 문자열으로 시작하면 true, 그렇지 않으면 false를 리턴
                .forEach(n -> System.out.println(n));
        System.out.println();

        // 중복 요소를 먼저 제거하고, 신으로 시작하는 요소만 필터링
        list.stream()
                .distinct()
                .filter(n -> n.startsWith("신"))
                // String의 startsWith() 메소드는 주어진 문자열으로 시작하면 true, 그렇지 않으면 false를 리턴
                .forEach(n -> System.out.println(n));
    }

    public void MapExample() {

        // List 컬렉션 생성
        List<Student2> student2List = new ArrayList<>();
        student2List.add(new Student2("홍길동", 85));
        student2List.add(new Student2("홍길동", 92));
        student2List.add(new Student2("홍길동", 87));

        // Student를 score 스크림으로 변환
        student2List.stream()
                .mapToInt(s -> s.getScore())
                .forEach(score -> System.out.println(score));
    }

    public void MapExample2() {
        int[] intArray = { 1, 2, 3, 4, 5 };

        IntStream intStream = Arrays.stream(intArray);
        intStream
                .asDoubleStream()
                .forEach(d -> System.out.println(d));

        System.out.println();

        intStream = Arrays.stream(intArray);
        intStream
                .boxed()
                .forEach(obj -> System.out.println(obj.intValue()));
    }

    public void FlatMappingExample() {
        // 문장 스트림을 단어 스트림으로 변환
        List<String> list1 = new ArrayList<>();
        list1.add("this is java");
        list1.add("i am a best developer");
        list1.stream().
                flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(word -> System.out.println(word));

        System.out.println();

        // 문자열 숫자 목록 스트림을 숫자 스트림으로 변환
        List<String> list2 = Arrays.asList("10, 20, 30, 40, 50");
        list2.stream()
                .flatMapToInt(data -> {
                    String[] strArr = data.split(",");
                    int[] intArr = new int[strArr.length];
                    for(int i = 0; i < strArr.length; i++) {
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(intArr);
                })
                .forEach(number -> System.out.println(number));
    }

    public void SortingExample() {
        //List 컬렉션 생성
        List<Student3> student3List = new ArrayList<>();
        student3List.add(new Student3("홍길동", 30));
        student3List.add(new Student3("신용권", 10));
        student3List.add(new Student3("유미선", 20));

        //점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
        student3List.stream()
                .sorted( )
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
        System.out.println();

        // 점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
        student3List.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
    }

    public void LoopingExample() {
        int[] intArr = { 1, 2, 3, 4, 5 };

        // 잘못 작성한 경우
        Arrays.stream(intArr)
                .filter(a -> a%2 == 0)
                .peek(n -> System.out.println(n));  // 최종 처리가 없으므로 동작하지 않음

        // 중간 처리 메소드 peak()을 이용해서 반복 처리
        int total = Arrays.stream(intArr)
                .filter(a -> a%2==0)
                .peek(n -> System.out.println(n))   // 동작함
                .sum(); // 최종 처리
        System.out.println("총합: " + total + "\n");

        // 최종 처리 메소드 forEach()를 이용해서 반복 처리
        Arrays.stream(intArr)
                .filter(a -> a%2==0)
                .forEach(n -> System.out.println(n));   // 최종 처리이므로 동작함
    }

    public void MatchingExample() {
        int [] intArr = { 2, 4, 6 };

        boolean result = Arrays.stream(intArr)
                .allMatch(a -> a%2==0);
        System.out.println("모두 의 배수인가? " + result);

        result = Arrays.stream(intArr)
                .anyMatch(a -> a%3 == 0);
        System.out.println("하나라도 3의 배수가 있는가? " + result);

        result = Arrays.stream(intArr)
                .noneMatch(a -> a%3 == 0);
        System.out.println("3의 배수가 없는가? " + result);
    }

    public void AggregateExample() {
        // 정수 배열
        int[] arr = { 1, 2, 3, 4, 5 };

        // 카운팅
        long count = Arrays.stream(arr)
                .filter(n -> n%2==0)
                .count();
        System.out.println("2의 배수 개수: " + count);

        // 총합
        long sum = Arrays.stream(arr)
                .filter(n -> n%2==0)
                .sum();
        System.out.println("2의 배수의 합: " + sum);

        // 평균
        double avg = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .average()
                .getAsDouble();
        System.out.println("2의 배수의 평균: " + avg);

        // 최대값
        int max = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .max()
                .getAsInt();
        System.out.println("최대값: " + max);

        // 최소값
        int min = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .min()
                .getAsInt();
        System.out.println("최소값: " + min);

        // 첫 번째 요소
        int first = Arrays.stream(arr)
                .filter(n -> n%3 == 0)
                .findFirst()
                .getAsInt();
        System.out.println("첫 번째 3의 배수: " + first);
    }

    public void OptionalExample() {
        List<Integer> list = new ArrayList<>();

        /* // 예외 발생(java.util.NoSuchElementException)
        double avg = list.stream()
        .mapToInt(Integer :: intValue)
        .average()
        .getAsDouble();

         */

        // 방법1
        OptionalDouble optional = list.stream()
                .mapToInt(Integer :: intValue)
                .average();
        if(optional.isPresent()) {
            System.out.println("방법1_평균: " + optional.getAsDouble());
        } else {
            System.out.println("방법1_평균: 0.0");
        }

        // 방법2
        double avg = list.stream()
                .mapToInt(Integer :: intValue)
                .average()
                .orElse(0.0);
        System.out.println("방법2_평균: " + avg);

        // 방법3
        list.stream()
                .mapToInt(Integer :: intValue)
                .average()
                .ifPresent(a -> System.out.println("방법3_평균" + a));
    }

    public void ReductionExample() {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 92),
                new Student("신용권", 95),
                new Student("감자바", 88)
        );
        // 방법1
        int sum1 = studentList.stream()
                .mapToInt(Student :: getScore)
                .sum();

        // 방법2
        int sum2 = studentList.stream()
                .map(Student :: getScore)
                .reduce(0, (a, b) -> a+b);

        System.out.println("sum1: " + sum1);
        System.out.println("sum2: " + sum2);
    }

    public void CollectExample() {
        List<Student4> totalList = new ArrayList<>();
        totalList.add(new Student4("홍길동", "남", 92));
        totalList.add(new Student4("김수영", "여", 87));
        totalList.add(new Student4("감자바", "남", 95));
        totalList.add(new Student4("오해영", "여", 93));

        List<Student4> maleList = totalList.stream()
                .filter(s -> s.getSex().equals("남"))
                .toList();

        maleList.stream()
                .forEach(s -> System.out.println(s.getName()));

        System.out.println();

        // 학생 이름을 키, 학생의 점수를 값으로 갖는 Map 생성
        Map<String, Integer> map = totalList.stream()
                .collect(
                        Collectors.toMap(
                                s -> s.getName(), // Student 객체에서 키가 될 부분 리턴
                                s-> s.getScore()  // Student 객체에서 값이 될 부분 리턴
                        )
                );

        System.out.println(map);
    }
}
