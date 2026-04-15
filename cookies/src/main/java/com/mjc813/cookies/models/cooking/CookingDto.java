package com.mjc813.cookies.models.cooking;

import com.mjc813.cookies.models.common.IdName;
import com.mjc813.cookies.models.cookie.CookieDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CookingDto implements CookingInterface {
	private Long id;
	private String description;

	private Long cookieId;
	private CookieDto cookie;

	public void setCookieId(Long cookieId) {
		// Long cookieId 랑 cookie.getId() 랑 값이 항상 같도록 해야 한다.
		if ( this.cookie == null ) {
			this.cookie = new CookieDto();
		}
		this.cookie.setId(this.cookieId);
		this.cookieId = cookieId;
	}

	public Long getCookieId() {
		// Long cookieId 랑 cookie.getId() 랑 값이 항상 같도록 해야 한다.
		this.setCookieId(this.cookieId);
		return this.cookieId;
	}

	@Override
	public void setCookie(IdName cookie) {
		// Long cookieId 랑 cookie.getId() 랑 값이 항상 같도록 해야 한다.
		if ( cookie == null ) {
			return;
		}
//		this.getCookie().copyMembers(cookie, true);
		this.setCookieId(cookie.getId());
	}
}
