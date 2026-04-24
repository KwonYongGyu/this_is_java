package cookies.models.cookie;

import com.mjc813.cookies.models.cookie.CookieDto;
import com.mjc813.cookies.models.cookie.CookieEntity;
import com.mjc813.cookies.models.cookie.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookieService {
	@Autowired
	private CookieRepository cookieRepository;

	public com.mjc813.cookies.models.cookie.CookieDto insert(com.mjc813.cookies.models.cookie.CookieDto insertDto) {
		CookieEntity CookieEntity = (CookieEntity)new CookieEntity().copyMembers(insertDto, true);
		CookieEntity.setId(null);
		CookieEntity save = this.cookieRepository.save(CookieEntity);
		com.mjc813.cookies.models.cookie.CookieDto result = (com.mjc813.cookies.models.cookie.CookieDto)new com.mjc813.cookies.models.cookie.CookieDto().copyMembers(save, true);
		return result;
	}

	public com.mjc813.cookies.models.cookie.CookieDto update(com.mjc813.cookies.models.cookie.CookieDto updateDto) {
		CookieEntity find = this.cookieRepository.findById(updateDto.getId()).orElseThrow();
		CookieEntity updateEntity = (CookieEntity)new CookieEntity().copyMembers(find, true);
		updateEntity.copyMembers(updateDto, false); // false 이유는 수정할 멤버변수값만 복사한다.
		CookieEntity save = this.cookieRepository.save(updateEntity);
		com.mjc813.cookies.models.cookie.CookieDto result = (com.mjc813.cookies.models.cookie.CookieDto)new com.mjc813.cookies.models.cookie.CookieDto().copyMembers(save, true);
		return result;
	}

	public com.mjc813.cookies.models.cookie.CookieDto findById(Long id) {
		CookieEntity find = this.cookieRepository.findById(id).orElseThrow();
		com.mjc813.cookies.models.cookie.CookieDto result = (com.mjc813.cookies.models.cookie.CookieDto)new com.mjc813.cookies.models.cookie.CookieDto().copyMembers(find, true);
		return result;
	}

	public com.mjc813.cookies.models.cookie.CookieDto deleteById(Long id) {
		com.mjc813.cookies.models.cookie.CookieDto find = this.findById(id);
		this.cookieRepository.deleteById(id);
		return find;
	}

	public Slice<com.mjc813.cookies.models.cookie.CookieDto> findByNameContains(String name, Pageable pageable) {
		Slice<CookieEntity> slc = this.cookieRepository.findByNameContains(name, pageable);
		List<com.mjc813.cookies.models.cookie.CookieDto> list = slc.getContent().stream()
				.map( t -> (com.mjc813.cookies.models.cookie.CookieDto)new com.mjc813.cookies.models.cookie.CookieDto().copyMembers(t, true))
				.toList();
		Slice<CookieDto> result = new SliceImpl<>(list, slc.getPageable(), slc.hasNext());
		return result;
	}
}
