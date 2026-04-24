package cookies.models.category;

import com.mjc813.cookies.models.category.CategoryDto;
import com.mjc813.cookies.models.category.CategoryEntity;
import com.mjc813.cookies.models.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public com.mjc813.cookies.models.category.CategoryDto insert(com.mjc813.cookies.models.category.CategoryDto insertDto) {
		CategoryEntity categoryEntity = (CategoryEntity)new CategoryEntity().copyMembers(insertDto, true);
		categoryEntity.setId(null);
		CategoryEntity save = this.categoryRepository.save(categoryEntity);
		com.mjc813.cookies.models.category.CategoryDto result = (com.mjc813.cookies.models.category.CategoryDto)new com.mjc813.cookies.models.category.CategoryDto().copyMembers(save, true);
		return result;
	}

	public com.mjc813.cookies.models.category.CategoryDto update(com.mjc813.cookies.models.category.CategoryDto updateDto) {
		CategoryEntity find = this.categoryRepository.findById(updateDto.getId()).orElseThrow();
		CategoryEntity updateEntity = (CategoryEntity)new CategoryEntity().copyMembers(find, true);
		updateEntity.copyMembers(updateDto, false); // false 이유는 수정할 멤버변수값만 복사한다.
		CategoryEntity save = this.categoryRepository.save(updateEntity);
		com.mjc813.cookies.models.category.CategoryDto result = (com.mjc813.cookies.models.category.CategoryDto)new com.mjc813.cookies.models.category.CategoryDto().copyMembers(save, true);
		return result;
	}

	public com.mjc813.cookies.models.category.CategoryDto findById(Long id) {
		CategoryEntity find = this.categoryRepository.findById(id).orElseThrow();
		com.mjc813.cookies.models.category.CategoryDto result = (com.mjc813.cookies.models.category.CategoryDto)new com.mjc813.cookies.models.category.CategoryDto().copyMembers(find, true);
		return result;
	}

	public com.mjc813.cookies.models.category.CategoryDto deleteById(Long id) {
		com.mjc813.cookies.models.category.CategoryDto find = this.findById(id);
		this.categoryRepository.deleteById(id);
		return find;
	}

	public Slice<com.mjc813.cookies.models.category.CategoryDto> findByNameContains(String name, Pageable pageable) {
		Slice<CategoryEntity> slc = this.categoryRepository.findByNameContains(name, pageable);
		List<com.mjc813.cookies.models.category.CategoryDto> list = slc.getContent().stream()
				.map( t -> (com.mjc813.cookies.models.category.CategoryDto)new com.mjc813.cookies.models.category.CategoryDto().copyMembers(t, true))
				.toList();
		Slice<CategoryDto> result = new SliceImpl<>(list, slc.getPageable(), slc.hasNext());
		return result;
	}
}
