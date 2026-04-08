package com.mjc813.cafe_kiosk.models.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
    // 필드명이 Name(대문자)이므로 규격에 맞춰 작성합니다.
    Slice<CategoryEntity> findByNameContains(String name, Pageable pageable);
}
