package com.mjc813.cookies.models.ingredient;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
	@EntityGraph(value = "IngredientEntity.fetchCategory")
	Slice<IngredientEntity> findAllByNameContaining(String name, Pageable pageable);
}
