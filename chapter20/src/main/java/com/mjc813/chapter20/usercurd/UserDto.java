package com.mjc813.chapter20.usercurd;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String email;

}
