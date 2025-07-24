package com.ocxide.borrowingsservice.borrowings.infrastructure;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ocxide.borrowingsservice.borrowings.infrastructure.http.CreateBorrowingDTO;
import com.ocxide.borrowingsservice.domain.Borrowing;

@Mapper(componentModel = "spring")
public interface BorrowingsMapper {
	@Mapping(target = "borrowedAt", expression = "java(java.time.Instant.now())")
	Borrowing toDomain(CreateBorrowingDTO dto);
}
