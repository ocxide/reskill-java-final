package com.ocxide.notificationsservice.notifications.infrastructure.kafka;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ocxide.notificationsservice.notifications.domain.Borrowing;

@Mapper(componentModel = "spring")
public interface KafkaBorrowingEventsMapper {

	@Mapping(target = "expirationNotified", constant = "false")
	@Mapping(target = "withExpirationNotified", ignore = true)
	Borrowing toDomain(BookCopyBorrowedEvent event);
}
