package com.ocxide.usersservice.domain;

public class UsernameAlreadyTakenError extends Exception {
	public UsernameAlreadyTakenError(String message) {
		super(String.format("Username already taken: %s", message));
	}
}
