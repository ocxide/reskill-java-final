package com.ocxide.notificationsservice.notifications.domain;

public record BookCopyNearExpiration(Borrowing borrowing) {

	@Override
	public String toString() {
		return String.format("NEAR_EXPIRATION: %s BookCopy %s borrowed by user %s at %s is near expiration", this.borrowing().id(),
				this.borrowing().bookCopyId(), this.borrowing().userId(),
				this.borrowing().borrowedAt());
	}
}
