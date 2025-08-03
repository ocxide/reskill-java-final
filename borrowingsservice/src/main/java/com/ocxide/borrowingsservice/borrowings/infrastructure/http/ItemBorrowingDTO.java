package com.ocxide.borrowingsservice.borrowings.infrastructure.http;

import java.time.Instant;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ItemBorrowingDTO", description = "Existing borrowing of a BookCopy")
public record ItemBorrowingDTO(
	Long id,
	Long userId,
	Long bookCopyId,
	Instant borrowedAt
) {
}
