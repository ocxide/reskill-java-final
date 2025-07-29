package com.ocxide.booksservice.bookeditions.infrastructure;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ocxide.booksservice.bookeditions.domain.BookEdition;
import com.ocxide.booksservice.bookeditions.infrastructure.db.BookEditionEntity;
import com.ocxide.booksservice.bookeditions.infrastructure.http.CreateBookEditionDTO;
import com.ocxide.booksservice.bookeditions.infrastructure.http.GetBookEditionDTO;

@Mapper(componentModel = "spring", uses = { ISBNMapper.class })
public interface BookEditionsMapper {

	@Mapping(target = "id", ignore = true)
	BookEdition toDomain(CreateBookEditionDTO dto);

	BookEditionEntity toEntity(BookEdition domain);
	BookEdition toDomain(BookEditionEntity entity);

	GetBookEditionDTO toDto(BookEdition domain);
}
