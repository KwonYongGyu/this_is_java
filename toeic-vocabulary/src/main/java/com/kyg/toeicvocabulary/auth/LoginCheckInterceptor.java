package com.kyg.toeicvocabulary.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;

@RequiredArgsConstructor
public class LoginCheckInterceptor implements HandlerInterceptor {

    private final SessionStore sessionStore;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionId = extractSessionId(request);
        String username = sessionStore.getUsername(sessionId);

        if (username == null) {
            response.sendRedirect("/login");
            return false; // 컨트롤러로 못 가게 막음
        }
        return true; // 로그인 되어 있으면 통과
    }

    private String extractSessionId(HttpServletRequest request) {
        if (request.getCookies() == null) return null;
        for (Cookie cookie : request.getCookies()) {
            if ("SESSION_ID".equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
