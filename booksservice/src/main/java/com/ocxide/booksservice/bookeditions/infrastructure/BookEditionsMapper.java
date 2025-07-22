package com.ocxide.booksservice.bookeditions.infrastructure;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ocxide.booksservice.bookeditions.domain.BookEdition;
import com.ocxide.booksservice.bookeditions.infrastructure.db.BookEditionEntity;
import com.ocxide.booksservice.bookeditions.infrastructure.http.CreateBookEditionDTO;

@Mapper(componentModel = "spring", uses = { ISBNMapper.class })
public interface BookEditionsMapper {
	
	BookEdition toDomain(CreateBookEditionDTO dto);	

	@Mapping(target = "id", ignore = true)
	BookEditionEntity toEntity(BookEdition domain);
}
