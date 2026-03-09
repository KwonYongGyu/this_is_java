package com.mjc813;

import java.util.Arrays;
import java.util.List;

public class CheckExample {
    public void number5(){
        List<String> list = Arrays.asList(
                "This is a java book",
                "Lamda Expressions",
                "Java8 supports lamda expressions"
        );

        list.stream()
                .filter(s -> s.toLowerCase().contains("java"))
                .forEach(System.out :: println);
    }

    public void number6() {
        List<Member> list = Arrays.asList(
                new Member("홍길동", 30),
                new Member("신용권", 40),
                new Member("감자바", 26)
        );

        double avg = list.stream()
                        .mapToInt(Member :: getAge) // Member 객체를 나이(int)로 매핑
                        .average()  // 평균 계산
                        .orElse(0.0);


        System.out.println("평균 나이: " + avg);
    }
}
