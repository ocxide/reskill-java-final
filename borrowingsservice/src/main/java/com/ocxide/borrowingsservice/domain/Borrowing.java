package com.ocxide.borrowingsservice.domain;

import java.time.Instant;

public record Borrowing(
		Long id,
		Long userId,
		Long bookCopyId,
		Instant borrowedAt) {
}
