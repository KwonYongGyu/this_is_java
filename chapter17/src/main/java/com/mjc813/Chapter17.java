package com.mjc813;


import com.mjc813.bookExample.Student;

import java.util.*;
import java.util.stream.Stream;

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
}
