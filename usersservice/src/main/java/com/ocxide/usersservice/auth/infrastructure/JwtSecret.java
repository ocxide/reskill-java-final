package com.ocxide.usersservice.auth.infrastructure;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtSecret {
	private final SecretKey key;

	JwtSecret(@Value("${jwt.secret}") String secret) {
		var base64 = Decoders.BASE64.decode(secret);
		this.key = Keys.hmacShaKeyFor(base64);
	}

	public SecretKey key() {
		return key;
	}
}
