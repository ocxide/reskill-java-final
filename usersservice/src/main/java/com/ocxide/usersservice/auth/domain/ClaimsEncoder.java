package com.ocxide.usersservice.auth.domain;

public interface ClaimsEncoder {
	String encode(UserPayload payload);
}
