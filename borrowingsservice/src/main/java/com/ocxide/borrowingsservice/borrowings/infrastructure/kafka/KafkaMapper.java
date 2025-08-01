package com.ocxide.borrowingsservice.borrowings.infrastructure.kafka;

import org.mapstruct.Mapper;

import com.ocxide.borrowingsservice.borrowings.domain.Borrowing;

@Mapper(componentModel = "spring")
public interface KafkaMapper {
	CopyBorrowedDTO toDTO(Borrowing borrowing);

}
