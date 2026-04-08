package com.mjc813.cafe_kiosk.models.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDto insert(CategoryDto categoryDto) {
        CategoryEntity newData = new CategoryEntity();
        newData.setName(categoryDto.getName());
        newData.setId(categoryDto.getId());

        CategoryEntity resEntity = this.categoryRepository.save(newData);

        CategoryDto result = new CategoryDto();
        result.setId(resEntity.getId());
        result.setName(resEntity.getName());
        return result;
    }

    public CategoryDto update(CategoryDto categoryDto) {
        // 기존 데이터를 ID로 조회
        Optional<CategoryEntity> optionalEntity = this.categoryRepository.findById(categoryDto.getId());

        if (optionalEntity.isPresent()) {
            CategoryEntity entity = optionalEntity.get();
            // Entity의 필드 Name(대문자)에 값 세팅
            entity.setName(categoryDto.getName());

            // 저장 (Update 실행)
            CategoryEntity resEntity = this.categoryRepository.save(entity);

            // 결과 Dto 생성 및 반환
            CategoryDto result = new CategoryDto();
            result.setId(resEntity.getId());
            result.setName(resEntity.getName());
            return result;
        }
        return null;
    }

    public CategoryDto deleteById(Integer id) {
        Optional<CategoryEntity> optionalEntity = this.categoryRepository.findById(id);

        if (optionalEntity.isPresent()) {
            CategoryEntity entity = optionalEntity.get();
            // 삭제 처리
            this.categoryRepository.delete(entity);

            // 삭제된 정보를 Dto에 담아 반환
            CategoryDto result = new CategoryDto();
            result.setId(entity.getId());
            result.setName(entity.getName());
            return result;
        }
        return null;
    }

    public CategoryDto findById(Integer id) {
        Optional<CategoryEntity> optionalEntity = this.categoryRepository.findById(id);

        if (optionalEntity.isPresent()) {
            CategoryEntity entity = optionalEntity.get();

            CategoryDto result = new CategoryDto();
            result.setId(entity.getId());
            result.setName(entity.getName());
            return result;
        }
        return null;
    }

    public Slice<CategoryDto> findByNameContains(String name, Pageable pageable) {
        // Repository에서 검색 결과 가져오기
        Slice<CategoryEntity> resEntities = this.categoryRepository.findByNameContains(name, pageable);

        // Slice 내부의 Entity들을 Dto로 하나씩 변환
        Slice<CategoryDto> result = resEntities.map(entity -> {
            CategoryDto dto = new CategoryDto();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            return dto;
        });

        return result;
    }
}