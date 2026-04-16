package com.mjc813.cookies.models.recipe;

import com.mjc813.cookies.models.cookie.CookieEntity;
import com.mjc813.cookies.models.ingredient.IngredientEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
	Slice<RecipeEntity> findAllByCookieEquals(CookieEntity cookie, Pageable pageable);
	Slice<RecipeEntity> findByIngredient(IngredientEntity ingredient, Pageable pageable);
}
