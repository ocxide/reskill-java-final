package com.ocxide.notificationsservice.notifications.infrastructure.db;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import io.r2dbc.postgresql.codec.Interval;
import lombok.Getter;
import lombok.Setter;

@Table("borrowings")
@Getter
@Setter
public class BorrowingEntity {

	@Id
	public Long id;

	@Column("user_id")
	public Long userId;

	@Column("book_copy_id")
	public Long bookCopyId;

	@Column("borrowed_at")
	public Instant borrowedAt;

	@Column("expires_past")
	public Interval expiresPast;

	@Column("expiration_notified")
	public Boolean expirationNotified;
}

