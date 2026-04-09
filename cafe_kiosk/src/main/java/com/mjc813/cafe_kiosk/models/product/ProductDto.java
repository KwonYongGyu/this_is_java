package com.mjc813.cafe_kiosk.models.product;

import com.mjc813.cafe_kiosk.models.category.CategoryDto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductDto {
    private Integer id;
    private String name;
    private Integer price;
    private CategoryDto category;
    private String picture;
}
