package com.mjc813.jwtsecurity_login.jwt;

public class JwtIllegalException extends RuntimeException {
    public JwtIllegalException(String message) {
        super(message);
    }
}
