package com.ocxide.usersservice.auth.infrastructure;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public record JwtSecret(SecretKey key) {
	JwtSecret(String secret) {
		this(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret)));
	}
}
