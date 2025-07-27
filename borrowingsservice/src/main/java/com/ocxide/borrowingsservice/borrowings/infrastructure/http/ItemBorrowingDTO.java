package com.ocxide.borrowingsservice.borrowings.infrastructure.http;

import java.time.Instant;

public record ItemBorrowingDTO(
	Long id,
	Long userId,
	Long bookCopyId,
	Instant borrowedAt
) {
}
