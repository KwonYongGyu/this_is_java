package com.mjc813.jwtsecurity_login.jwt;


import com.mjc813.jwtsecurity_login.models.member.IMember;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {
//	@Value("${myapp.jwt.secret:thisismyjwtsecretkey!123456abcdef}")
	private String secret = "thisismyjwtsecretkey!123456abcdef";
//	@Value("${myapp.jwt.expireAccessToken}")
	private Long expireAccessToken = 1800000L; // 30분
	private Long expireRefreshToken = 604800000L; // 7일

    private final SecretKey secretKey;

    public JwtUtils() {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }

	public String generateAccessToken(String value) {
		return this.generateToken(value, this.expireAccessToken);
	}

	public String generateRefreshToken(String value) {
		return this.generateToken(value, this.expireRefreshToken);
	}

	public String generateToken(String value, Long milliSeconds) {
		String str = Jwts.builder()
				.subject(value)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + milliSeconds))
				.signWith(this.secretKey)
				.compact();
		return str;
	}

    public String generateToken(String value ,Long milliseconds) {
        String str = Jwts.builder()
                .subject(member.getSignId())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + this.expireAccessToken))
                .compact();
        return str;
    }
}
