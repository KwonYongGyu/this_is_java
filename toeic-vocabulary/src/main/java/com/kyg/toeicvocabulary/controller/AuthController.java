package com.kyg.toeicvocabulary.controller;

import com.kyg.toeicvocabulary.auth.SessionStore;
import com.kyg.toeicvocabulary.domain.User;
import com.kyg.toeicvocabulary.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SessionStore sessionStore;

    @GetMapping("/login")
    public String loginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpServletResponse response) {

        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isEmpty() || !passwordEncoder.matches(password, userOpt.get().getPassword())) {
            model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "auth/login";
        }

        String sessionId = sessionStore.createSession(username);

        Cookie cookie = new Cookie("SESSION_ID", sessionId);
        cookie.setHttpOnly(true);     // JS에서 접근 불가 (XSS 방어)
        cookie.setSecure(false);      // 로컬 개발(HTTP)이라 false, 배포 시 true로 변경
        cookie.setPath("/");
        cookie.setAttribute("SameSite", "Lax"); // CSRF 방어
        cookie.setMaxAge(60 * 60); // 1시간
        response.addCookie(cookie);

        return "redirect:/words";
    }

    @GetMapping("/logout")
    public String logout(@CookieValue(value = "SESSION_ID", required = false) String sessionId,
                         HttpServletResponse response) {
        sessionStore.invalidate(sessionId);

        Cookie cookie = new Cookie("SESSION_ID", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:/login";
    }
}
