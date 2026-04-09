package com.mjc813.cafe_kiosk.models.product;

import com.mjc813.cafe_kiosk.models.category.CategoryDto;
import com.mjc813.cafe_kiosk.models.category.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private  final ProductRepository productRepository;

    public ProductDto insert(ProductDto newDto) {
        ProductEntity newEntity = ProductEntity.builder()
                .name(newDto.getName())
                .price(newDto.getPrice())
                .category(new CategoryEntity())
//                .category(newDto.getCategory()) => 단순 객체 복사가 아니라 형변환을 해야한다.
                .picture(newDto.getPicture())
                .build();
        newEntity.getCategory().setId(newDto.getCategory().getId());
//        newEntity.getCategory().setName(newDto.getCategory().getName());

        ProductEntity save = this.productRepository.save(newEntity);

        ProductDto result = ProductDto.builder()
                .id(save.getId())
                .name(save.getName())
                .price(save.getPrice())
                .category(new CategoryDto()) // => 단순 객체 복사가 아니라 형변환을 해야 한다.
                .picture(save.getPicture())
                .build();
        result.getCategory().setId(save.getCategory().getId());
        result.getCategory().setName(save.getCategory().getName());
        return result;
    }
}
