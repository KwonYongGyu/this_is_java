package com.mjc813.ch12;

import lombok.Data;
import lombok.NonNull;

@Data
public class Member5 {
    private final String id;    //초기화된 final 필드는 변경할 수 없지만 (Setter가 만들어 지지 않음)
    @NonNull private String name;   // @NonNull은 null 값이 아닌 다른 값으로 Setter를 통해 변경할 수 있다는 것이다.
    private int age;
}
