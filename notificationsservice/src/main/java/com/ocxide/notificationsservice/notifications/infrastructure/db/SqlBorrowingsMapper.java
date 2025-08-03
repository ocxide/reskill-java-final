package com.ocxide.notificationsservice.notifications.infrastructure.db;

import java.time.Duration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.ocxide.notificationsservice.notifications.domain.Borrowing;

import io.r2dbc.postgresql.codec.Interval;

@Mapper(componentModel = "spring")
public interface SqlBorrowingsMapper {

	@Mapping(target = "expiresPast", qualifiedByName = "durationToInterval")
	BorrowingEntity toEntity(Borrowing borrowing);

	@Named("durationToInterval")
	default Interval toInterval(Duration duration) {
		return Interval.of(duration);
	}

	@Named("intervalToDuration")
	default Duration toDuration(Interval interval) {
		return interval.getDuration();
	}

}
