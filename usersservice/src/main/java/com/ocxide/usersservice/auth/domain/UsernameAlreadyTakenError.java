package com.ocxide.usersservice.auth.domain;

public class UsernameAlreadyTakenError extends Exception {
	public UsernameAlreadyTakenError(String message) {
		super(String.format("Username already taken: %s", message));
	}
}
