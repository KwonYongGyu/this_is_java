package com.mjc813.sbsecurity_login.config;

import com.mjc813.sbsecurity_login.models.member.MemberDto;
import com.mjc813.sbsecurity_login.models.member.MemberService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component // 클래스를 객체로 만들기 위해
public class KYGAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private MemberService memberService;
    @Override
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object signObj = session.getAttribute("MJC_LOGIN");
        if ( signObj instanceof String signId ) {
            MemberDto find = this.memberService.findBySignId(signId);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    find, null, find.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
    }
}
