package com.mjc813.swim_db.models.teacher;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "teacher")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String main;

    @Column(nullable = false)
    private Long birthYear;

    @Column(nullable = false)
    private Long swimPoolId;
}
