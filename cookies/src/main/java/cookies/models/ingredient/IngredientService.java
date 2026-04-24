package cookies.models.ingredient;

import com.mjc813.cookies.models.category.CategoryEntity;
import com.mjc813.cookies.models.category.CategoryRepository;
import com.mjc813.cookies.models.ingredient.IngredientDto;
import com.mjc813.cookies.models.ingredient.IngredientEntity;
import com.mjc813.cookies.models.ingredient.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
	@Autowired
	private IngredientRepository ingredientRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	public com.mjc813.cookies.models.ingredient.IngredientDto insert(com.mjc813.cookies.models.ingredient.IngredientDto insertDto) {
		com.mjc813.cookies.models.ingredient.IngredientEntity newEntity = (com.mjc813.cookies.models.ingredient.IngredientEntity)new com.mjc813.cookies.models.ingredient.IngredientEntity().copyMembers(insertDto, true);
		newEntity.setId(null);
		com.mjc813.cookies.models.ingredient.IngredientEntity save = this.ingredientRepository.save(newEntity);
		com.mjc813.cookies.models.ingredient.IngredientDto result = (com.mjc813.cookies.models.ingredient.IngredientDto)new com.mjc813.cookies.models.ingredient.IngredientDto().copyMembers(save, true);
		return result;
	}

	public com.mjc813.cookies.models.ingredient.IngredientDto update(com.mjc813.cookies.models.ingredient.IngredientDto updateDto) {
		com.mjc813.cookies.models.ingredient.IngredientEntity find = this.ingredientRepository.findById(updateDto.getId()).orElseThrow();
		com.mjc813.cookies.models.ingredient.IngredientEntity updateEntity = (com.mjc813.cookies.models.ingredient.IngredientEntity)new com.mjc813.cookies.models.ingredient.IngredientEntity().copyMembers(find, true);
		updateEntity.copyMembers(updateDto, false);
		com.mjc813.cookies.models.ingredient.IngredientEntity save = this.ingredientRepository.save(updateEntity);
		com.mjc813.cookies.models.ingredient.IngredientDto result = (com.mjc813.cookies.models.ingredient.IngredientDto)new com.mjc813.cookies.models.ingredient.IngredientDto().copyMembers(save, true);
		return result;
	}

	public com.mjc813.cookies.models.ingredient.IngredientDto findById(Long id) {
		com.mjc813.cookies.models.ingredient.IngredientEntity find = this.ingredientRepository.findById(id).orElseThrow();
		com.mjc813.cookies.models.ingredient.IngredientDto result = (com.mjc813.cookies.models.ingredient.IngredientDto)new com.mjc813.cookies.models.ingredient.IngredientDto().copyMembers(find, true);
		return result;
	}

	public com.mjc813.cookies.models.ingredient.IngredientDto deleteById(Long id) {
		com.mjc813.cookies.models.ingredient.IngredientDto find = this.findById(id);
		this.ingredientRepository.deleteById(id);
		return find;
	}

	public Slice<com.mjc813.cookies.models.ingredient.IngredientDto> findAllByNameContaining(String name, Pageable pageable) {
		Slice<com.mjc813.cookies.models.ingredient.IngredientEntity> slc = this.ingredientRepository.findAllByNameContaining(name, pageable);
		List<com.mjc813.cookies.models.ingredient.IngredientDto> list = slc.getContent().stream()
				.map( x -> (com.mjc813.cookies.models.ingredient.IngredientDto) new com.mjc813.cookies.models.ingredient.IngredientDto().copyMembers(x, true))
				.toList();
		Slice<com.mjc813.cookies.models.ingredient.IngredientDto> result = new SliceImpl<>(list, slc.getPageable(), slc.hasNext());
		return result;
	}

	public Slice<com.mjc813.cookies.models.ingredient.IngredientDto> findAllByCategoryEquals(Long categoryId, Pageable pageable) {
		CategoryEntity category = categoryRepository.findById(categoryId).orElseThrow();
		Slice<IngredientEntity> slc = this.ingredientRepository.findAllByCategoryEquals(category, pageable);
		List<com.mjc813.cookies.models.ingredient.IngredientDto> list = slc.getContent().stream()
				.map( x -> (com.mjc813.cookies.models.ingredient.IngredientDto) new com.mjc813.cookies.models.ingredient.IngredientDto().copyMembers(x, true))
				.toList();
		Slice<IngredientDto> result = new SliceImpl<>(list, slc.getPageable(), slc.hasNext());
		return result;
	}
}
