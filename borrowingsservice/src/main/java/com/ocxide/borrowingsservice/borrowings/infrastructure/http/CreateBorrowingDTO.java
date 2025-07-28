package com.ocxide.borrowingsservice.borrowings.infrastructure.http;

import java.time.Duration;

import jakarta.validation.constraints.NotNull;

public record CreateBorrowingDTO(@NotNull Long userId,
		@NotNull Long bookCopyId,
		@NotNull Duration expiresPast) {
}
