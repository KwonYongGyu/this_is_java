package com.mjc813.cafe_kiosk.models.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "category") // @Entity 는 JPA 에서 CRUD 를 할 수 있는 객체, 테이블
public class CategoryEntity {
    @Id
    private Integer id;

    @Column(name = "name", length = 50,nullable = false)
    private String Name;
}
