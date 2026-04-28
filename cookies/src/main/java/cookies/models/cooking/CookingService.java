package cookies.models.cooking;

import com.mjc813.cookies.models.cookie.CookieEntity;
import com.mjc813.cookies.models.cooking.CookingDto;
import com.mjc813.cookies.models.cooking.CookingEntity;
import com.mjc813.cookies.models.cooking.CookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookingService {
	@Autowired
	private CookingRepository cookingRepository;

	public com.mjc813.cookies.models.cooking.CookingDto insert(com.mjc813.cookies.models.cooking.CookingDto insertDto) {
		com.mjc813.cookies.models.cooking.CookingEntity newEntity = (com.mjc813.cookies.models.cooking.CookingEntity)new com.mjc813.cookies.models.cooking.CookingEntity().copyMembers(insertDto, true);
		newEntity.setId(null);
		com.mjc813.cookies.models.cooking.CookingEntity save = this.cookingRepository.save(newEntity);
		com.mjc813.cookies.models.cooking.CookingDto result = (com.mjc813.cookies.models.cooking.CookingDto)new com.mjc813.cookies.models.cooking.CookingDto().copyMembers(save, true);
		return result;
	}

	public com.mjc813.cookies.models.cooking.CookingDto update(com.mjc813.cookies.models.cooking.CookingDto updateDto) {
		com.mjc813.cookies.models.cooking.CookingEntity find = this.cookingRepository.findById(updateDto.getId()).orElseThrow();
		com.mjc813.cookies.models.cooking.CookingEntity updateEntity = (com.mjc813.cookies.models.cooking.CookingEntity)new com.mjc813.cookies.models.cooking.CookingEntity().copyMembers(find, true);
		updateEntity.copyMembers(updateDto, false);
		com.mjc813.cookies.models.cooking.CookingEntity save = this.cookingRepository.save(updateEntity);
		com.mjc813.cookies.models.cooking.CookingDto result = (com.mjc813.cookies.models.cooking.CookingDto)new com.mjc813.cookies.models.cooking.CookingDto().copyMembers(save, true);
		return result;
	}

	public com.mjc813.cookies.models.cooking.CookingDto findById(Long id) {
		com.mjc813.cookies.models.cooking.CookingEntity find = this.cookingRepository.findById(id).orElseThrow();
		com.mjc813.cookies.models.cooking.CookingDto result = (com.mjc813.cookies.models.cooking.CookingDto)new com.mjc813.cookies.models.cooking.CookingDto().copyMembers(find, true);
		return result;
	}

	public com.mjc813.cookies.models.cooking.CookingDto deleteById(Long id) {
		com.mjc813.cookies.models.cooking.CookingDto find = this.findById(id);
		this.cookingRepository.deleteById(id);
		return find;
	}

	public Slice<com.mjc813.cookies.models.cooking.CookingDto> findAllByDescriptionContaining(String description, Pageable pageable) {
		Slice<com.mjc813.cookies.models.cooking.CookingEntity> slc = this.cookingRepository.findAllByDescriptionContaining(description, pageable);
		List<com.mjc813.cookies.models.cooking.CookingDto> list = slc.getContent().stream()
				.map( x -> (com.mjc813.cookies.models.cooking.CookingDto) new com.mjc813.cookies.models.cooking.CookingDto().copyMembers(x, true))
				.toList();
		Slice<com.mjc813.cookies.models.cooking.CookingDto> result = new SliceImpl<>(list, slc.getPageable(), slc.hasNext());
		return result;
	}

	public Slice<com.mjc813.cookies.models.cooking.CookingDto> findAllByCookieEquals(Long cookieId, Pageable pageable) {
		CookieEntity cookie = CookieEntity.builder().id(cookieId).build();
		Slice<CookingEntity> slc = this.cookingRepository.findAllByCookieEquals(cookie, pageable);
		List<com.mjc813.cookies.models.cooking.CookingDto> list = slc.getContent().stream()
				.map( x -> (com.mjc813.cookies.models.cooking.CookingDto) new com.mjc813.cookies.models.cooking.CookingDto().copyMembers(x, true))
				.toList();
		Slice<CookingDto> result = new SliceImpl<>(list, slc.getPageable(), slc.hasNext());
		return result;
	}
}
