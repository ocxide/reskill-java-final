package com.ocxide.borrowingsservice.domain;

import java.time.Instant;

public record Borrowing(
		Long userId,
		Long bookCopyId,
		Instant borrowedAt) {
}
