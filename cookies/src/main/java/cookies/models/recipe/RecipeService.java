package cookies.models.recipe;

import com.mjc813.cookies.models.cookie.CookieEntity;
import com.mjc813.cookies.models.ingredient.IngredientEntity;
import com.mjc813.cookies.models.recipe.RecipeDto;
import com.mjc813.cookies.models.recipe.RecipeEntity;
import com.mjc813.cookies.models.recipe.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
	private final RecipeRepository recipeRepository;

	public com.mjc813.cookies.models.recipe.RecipeDto insert(com.mjc813.cookies.models.recipe.RecipeDto insertDto) {
		com.mjc813.cookies.models.recipe.RecipeEntity insertEntity = (com.mjc813.cookies.models.recipe.RecipeEntity)new com.mjc813.cookies.models.recipe.RecipeEntity().copyMembers(insertDto, true);
		insertEntity.setId(null);
		com.mjc813.cookies.models.recipe.RecipeEntity save = this.recipeRepository.save(insertEntity);
		com.mjc813.cookies.models.recipe.RecipeDto result = (com.mjc813.cookies.models.recipe.RecipeDto)new com.mjc813.cookies.models.recipe.RecipeDto().copyMembers(save, true);
		return result;
	}

	public com.mjc813.cookies.models.recipe.RecipeDto findById(Long id) {
//		RecipeEntity findEntity = this.recipeRepository.findById(id).orElseThrow();
		com.mjc813.cookies.models.recipe.RecipeEntity findEntity = this.recipeRepository.findJoinAllById(id).orElseThrow();
		com.mjc813.cookies.models.recipe.RecipeDto result = (com.mjc813.cookies.models.recipe.RecipeDto)new com.mjc813.cookies.models.recipe.RecipeDto().copyMembers(findEntity, true);
		return result;
	}

	public com.mjc813.cookies.models.recipe.RecipeDto update(com.mjc813.cookies.models.recipe.RecipeDto updateDto) {
		com.mjc813.cookies.models.recipe.RecipeEntity findEntity = this.recipeRepository.findById(updateDto.getId()).orElseThrow();
		com.mjc813.cookies.models.recipe.RecipeEntity updateEntity = (com.mjc813.cookies.models.recipe.RecipeEntity)new com.mjc813.cookies.models.recipe.RecipeEntity().copyMembers(findEntity, true);
		updateEntity.copyMembers(updateDto, false);
		com.mjc813.cookies.models.recipe.RecipeEntity save = this.recipeRepository.save(updateEntity);
		com.mjc813.cookies.models.recipe.RecipeDto result = (com.mjc813.cookies.models.recipe.RecipeDto)new com.mjc813.cookies.models.recipe.RecipeDto().copyMembers(save, true);
		return result;
	}

	public com.mjc813.cookies.models.recipe.RecipeDto deleteById(Long id) {
		com.mjc813.cookies.models.recipe.RecipeDto result = this.findById(id);
		this.recipeRepository.deleteById(id);
		return result;
	}

	public Slice<com.mjc813.cookies.models.recipe.RecipeDto> findAllByCookieEquals(Long cookieId, Pageable pageable) {
		CookieEntity cookie = CookieEntity.builder().id(cookieId).build();
		Slice<com.mjc813.cookies.models.recipe.RecipeEntity> slice = this.recipeRepository.findAllByCookieEquals(cookie, pageable);
		return this.getSliceRecipeDto(slice);
	}

	public Slice<com.mjc813.cookies.models.recipe.RecipeDto> findByIngredient(Long ingredientId, Pageable pageable) {
		IngredientEntity ingredient = IngredientEntity.builder().id(ingredientId).build();
		Slice<com.mjc813.cookies.models.recipe.RecipeEntity> slice = this.recipeRepository.findByIngredient(ingredient, pageable);
		return this.getSliceRecipeDto(slice);
	}

	private Slice<com.mjc813.cookies.models.recipe.RecipeDto> getSliceRecipeDto(Slice<RecipeEntity> slice) {
		List<com.mjc813.cookies.models.recipe.RecipeDto> list = slice.getContent().stream()
				.map( item -> (com.mjc813.cookies.models.recipe.RecipeDto)new com.mjc813.cookies.models.recipe.RecipeDto().copyMembers(item, true))
				.toList();
		Slice<RecipeDto> result = new SliceImpl<>(list, slice.getPageable(), slice.hasNext());
		return result;
	}
}
