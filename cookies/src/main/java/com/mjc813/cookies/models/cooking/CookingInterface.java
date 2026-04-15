package com.mjc813.cookies.models.cooking;

import com.mjc813.cookies.models.common.IdName;

public interface CookingInterface {
	Long getId();
	void setId(Long id);

	String getDescription();
	void setDescription(String description);
	
	Long getCookieId();
	void setCookieId(Long cookieId);

	IdName getCookie();
	void setCookie(IdName cookie);
}
