package com.mjc813.cookies.models.ingredient;

import com.mjc813.cookies.models.category.CategoryDto;
import com.mjc813.cookies.models.common.IdName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientDto implements IngredientInterface {
	private Long id;
	private String name;
	private Long categoryId;
	private CategoryDto category;

	@Override
	public void setCategoryId(Long categoryId) {
		// Long categoryId 랑 category.getId() 랑 값이 항상 같도록 해야 한다.
		if ( this.category == null ) {
			this.category = new CategoryDto();
		}
		this.category.setId(this.categoryId);
		this.categoryId = categoryId;
	}

	@Override
	public Long getCategoryId() {
		// Long categoryId 랑 category.getId() 랑 값이 항상 같도록 해야 한다.
		this.setCategoryId(this.categoryId);
		return this.categoryId;
	}

	@Override
	public void setCategory(IdName category) {
		// Long categoryId 랑 category.getId() 랑 값이 항상 같도록 해야 한다.
		if ( category == null ) {
			return;
		}
//		this.getCategory().copyMembers(category, true);
		this.setCategoryId(category.getId());
	}
}
