package com.ocxide.usersservice.auth.infrastructure.http;

import jakarta.validation.constraints.NotBlank;

public record SignInDTO(
		@NotBlank String username,
		@NotBlank String password) {
}
