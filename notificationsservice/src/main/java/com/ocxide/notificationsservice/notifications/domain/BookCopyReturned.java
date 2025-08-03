package com.ocxide.notificationsservice.notifications.domain;

public record BookCopyReturned(Borrowing borrowing) {

	@Override
	public String toString() {
		return String.format("RETURNED: %s BookCopy %s returned by user %s", this.borrowing().id(),
				this.borrowing().bookCopyId(), this.borrowing().userId());
	}
}
