package com.ocxide.borrowingsservice.borrowings.infrastructure;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ocxide.borrowingsservice.borrowings.infrastructure.db.BorrowingEntity;
import com.ocxide.borrowingsservice.borrowings.infrastructure.http.CreateBorrowingDTO;
import com.ocxide.borrowingsservice.borrowings.infrastructure.http.ItemBorrowingDTO;
import com.ocxide.borrowingsservice.borrowings.domain.Borrowing;

@Mapper(componentModel = "spring", uses = { PostgresIntervalMapper.class })
public interface BorrowingsMapper {
	@Mapping(target = "borrowedAt", expression = "java(java.time.Instant.now())")
	@Mapping(target = "id", ignore = true)
	Borrowing toDomain(CreateBorrowingDTO dto);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "expiresPast", qualifiedByName = "durationToInterval")
	BorrowingEntity toEntity(Borrowing domain);

	@Mapping(target = "expiresPast", qualifiedByName = "intervalToDuration")
	Borrowing entityToDomain(BorrowingEntity entity);

	ItemBorrowingDTO domainToDTO(Borrowing domain);
}
