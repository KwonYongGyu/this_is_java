package com.mjc813.cookies.models.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public CategoryDto insert(CategoryDto insertDto) {
		CategoryEntity categoryEntity = (CategoryEntity)new CategoryEntity().copyMembers(insertDto, true);
		categoryEntity.setId(null);
		CategoryEntity save = this.categoryRepository.save(categoryEntity);
		CategoryDto result = (CategoryDto)new CategoryDto().copyMembers(save, true);
		return result;
	}

	public CategoryDto update(CategoryDto updateDto) {
		CategoryEntity find = this.categoryRepository.findById(updateDto.getId()).orElseThrow();
		CategoryEntity updateEntity = (CategoryEntity)new CategoryEntity().copyMembers(find, true);
		updateEntity.copyMembers(updateDto, false); // false 이유는 수정할 멤버변수값만 복사한다.
		CategoryEntity save = this.categoryRepository.save(updateEntity);
		CategoryDto result = (CategoryDto)new CategoryDto().copyMembers(save, true);
		return result;
	}
}
