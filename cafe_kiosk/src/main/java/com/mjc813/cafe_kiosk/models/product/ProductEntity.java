package com.mjc813.cafe_kiosk.models.product;

import com.mjc813.cafe_kiosk.models.category.CategoryEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @JoinColumn(name="category_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoryEntity category;

    @Column(length = 500, nullable = true)
    private String picture;
}
