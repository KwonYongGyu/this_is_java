package cookies.models.cookie;

import com.mjc813.cookies.models.cookie.CookieEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookieRepository extends JpaRepository<CookieEntity, Long> {
	Slice<CookieEntity> findByNameContains(String name, Pageable pageable);
}
