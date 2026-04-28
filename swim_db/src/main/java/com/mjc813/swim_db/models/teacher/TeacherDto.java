package com.mjc813.swim_db.models.teacher;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDto {
    private Long id;
    private String name;
    private String main;
    private Long birthYear;
    private Long swimPoolId;

}
