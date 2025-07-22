package com.ocxide.usersservice.auth.infrastructure;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ocxide.usersservice.auth.domain.ClaimsEncoder;
import com.ocxide.usersservice.auth.domain.UserPayload;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtEncoder implements ClaimsEncoder {
	private final JwtSecret secret;

	@Value("${spring.application.name}")
	private String issuer;

	@Value("${jwt.expiration}")
	private Long expiration;

	@Override
	public String encode(UserPayload payload) {
		var now = new Date(System.currentTimeMillis());
		var exp = new Date(now.getTime() + expiration);

		return io.jsonwebtoken.Jwts.builder()
				.issuer(issuer)
				.subject(payload.id().toString())
				.issuedAt(now)
				.expiration(exp)
				.signWith(secret.key())
				.compact();
	}
}
