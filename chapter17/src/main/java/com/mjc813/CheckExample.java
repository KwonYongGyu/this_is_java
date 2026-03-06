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
                .filter(n -> n.startsWith("java"))
                .forEach(n -> System.out.println(n));
        System.out.println();

        // 중복 요소를 제거하고, java가 포함된 요소만 필터링
        list.stream()
                .distinct()
                .filter(n -> n.startsWith("java"))
                .forEach(n -> System.out.println(n));
    }
}
