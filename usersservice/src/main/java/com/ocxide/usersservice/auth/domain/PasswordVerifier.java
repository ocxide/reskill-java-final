package com.ocxide.usersservice.auth.domain;

public interface PasswordVerifier {

	boolean verify(String attemp, String encoded);
}
