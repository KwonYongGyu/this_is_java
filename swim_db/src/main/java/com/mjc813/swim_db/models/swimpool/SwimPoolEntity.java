package com.mjc813.swim_db.models.swimpool;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "swim_pool")
public class SwimPoolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 30, nullable = true)
    private String tel;

    @Column(length = 200, nullable = true)
    private String addr1;

    @Column(length = 200, nullable = true)
    private String addr2;

    @Column(length = 200, nullable = true)
    private String lanes;

    @Column(length = 50, nullable = true)
    private String size;
}

