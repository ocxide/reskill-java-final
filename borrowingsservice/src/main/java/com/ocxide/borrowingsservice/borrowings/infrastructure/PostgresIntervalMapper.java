package com.ocxide.borrowingsservice.borrowings.infrastructure;

import java.time.Duration;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import io.r2dbc.postgresql.codec.Interval;

@Mapper(componentModel = "spring")
public abstract class PostgresIntervalMapper {
	@Named("durationToInterval")
	public Interval toInterval(Duration duration) {
		return Interval.of(duration);	
	}	
	
	@Named("intervalToDuration")
	public Duration toDuration(Interval interval) {
		return interval.getDuration();
	}
}
