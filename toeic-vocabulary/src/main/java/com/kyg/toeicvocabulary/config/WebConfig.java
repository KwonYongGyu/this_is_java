package com.kyg.toeicvocabulary.config;

import com.kyg.toeicvocabulary.auth.LoginCheckInterceptor;
import com.kyg.toeicvocabulary.auth.SessionStore;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final SessionStore sessionStore;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor(sessionStore))
                .order(1)
                .addPathPatterns("/words/**")   // /words로 시작하는 화면 전체 보호
                .excludePathPatterns(
                        "/login", "/logout",     // 로그인 관련은 제외
                        "/css/**", "/js/**", "/images/**" // 정적 리소스 제외
                );
    }
}
