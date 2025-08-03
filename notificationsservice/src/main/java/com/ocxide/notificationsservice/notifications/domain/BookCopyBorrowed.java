package com.ocxide.notificationsservice.notifications.domain;

public record BookCopyBorrowed(Borrowing borrowing) {

	@Override
	public String toString() {
		return String.format("BORROWED: %s BookCopy %s borrowed by user %s at %s for %s", this.borrowing().id(),
				this.borrowing().bookCopyId(), this.borrowing().userId(),
				this.borrowing().borrowedAt(), this.borrowing().expiresPast());
	}
}
