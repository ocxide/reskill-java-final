package com.ocxide.usersservice.infrastructure;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
		@NotBlank @Size(min = 3) String username, @NotBlank @Size(min = 10) String password) {
}
