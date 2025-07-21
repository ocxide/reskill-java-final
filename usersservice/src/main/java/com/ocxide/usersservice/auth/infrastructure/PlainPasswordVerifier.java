package com.ocxide.usersservice.auth.infrastructure;

import com.ocxide.usersservice.auth.domain.PasswordVerifier;

public class PlainPasswordVerifier implements PasswordVerifier {

	@Override
	public boolean verify(String attemp, String encoded) {
		return attemp.equals(encoded);
	}
}
