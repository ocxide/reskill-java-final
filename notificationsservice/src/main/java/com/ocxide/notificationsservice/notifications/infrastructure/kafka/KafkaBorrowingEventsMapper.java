package com.ocxide.notificationsservice.notifications.infrastructure.kafka;

import org.mapstruct.Mapper;

import com.ocxide.notificationsservice.notifications.domain.Borrowing;

@Mapper(componentModel = "spring")
public interface KafkaBorrowingEventsMapper {

	Borrowing toDomain(BookCopyBorrowedEvent event);
}
