package com.ocxide.usersservice.auth.infrastructure.http;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
		@NotBlank @Size(min = 3) String username, @NotBlank @Size(min = 10) String password) {
}
