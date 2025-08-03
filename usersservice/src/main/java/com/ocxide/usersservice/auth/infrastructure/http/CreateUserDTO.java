package com.ocxide.usersservice.auth.infrastructure.http;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
		@NotBlank @Size(min = 3) @Schema(description = "Non-existing username") String username,
		@NotBlank @Size(min = 10) String password) {
}
