package com.mjc813.cookies.models.ingredient;

import com.mjc813.cookies.models.common.IdName;

public interface IngredientInterface extends IdName {
	Long getCategoryId();
	void setCategoryId(Long categoryId);

	IdName getCategory();
	void setCategory(IdName category);
}
