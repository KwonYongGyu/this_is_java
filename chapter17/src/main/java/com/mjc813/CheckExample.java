package com.mjc813;

import com.mjc813.checkExample.Member;
import com.mjc813.checkExample.Member2;
import com.mjc813.checkExample.Member3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckExample {
    public void Number5(){
        List<String> list = Arrays.asList(
                "This is a java book",
                "Lamda Expressions",
                "Java8 supports lamda expressions"
        );

        list.stream()
                .filter(s -> s.toLowerCase().contains("java"))
                .forEach(System.out :: println);
    }

    public void Number6() {
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

    public void Number7() {
        List<Member2> list = Arrays.asList(
                new Member2("홍길동", "개발자")
                , new Member2("김나리", "디자이너")
                , new Member2("신용권", "개발자")
        );

        List<Member2> developers = list.stream()
                        .filter(s -> s.getJob().equals("개발자"))
                        .collect(Collectors.toList());
        developers
                .stream()
                .forEach(m -> System.out.println(m.getName()));
    }

    public void Number8() {
        List<Member3> list = Arrays.asList(
                new Member3("홍길동", "개발자")
                ,new Member3("김나리", "디자이너")
                ,new Member3("신용권", "개발자")
        );

        Map<String, List<Member3>> groupingMap = list.stream()
                .collect(Collectors.groupingBy(m -> m.getJob()));

        System.out.println("[개발자]");
        groupingMap.get("개발자").forEach(m -> System.out.println(m));

        System.out.println();

        System.out.println("[디자이너]");
        groupingMap.get("디자이너").forEach(m -> System.out.println(m));
    }
}
