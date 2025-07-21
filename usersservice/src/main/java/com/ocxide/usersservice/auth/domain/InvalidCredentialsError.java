package com.ocxide.usersservice.auth.domain;

public class InvalidCredentialsError extends Exception {
	
	public InvalidCredentialsError() {
		super("Invalid credentials");
	}
	
}
