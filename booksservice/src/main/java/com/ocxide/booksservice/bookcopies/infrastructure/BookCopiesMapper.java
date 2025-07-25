package com.ocxide.booksservice.bookcopies.infrastructure;

import java.time.Instant;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.ocxide.booksservice.bookcopies.domain.BookCopy;
import com.ocxide.booksservice.bookcopies.infrastructure.db.BookCopyEntity;
import com.ocxide.booksservice.bookcopies.infrastructure.http.CreateBookCopyDTO;
import com.ocxide.booksservice.bookcopies.infrastructure.http.GetOneBookCopyDTO;

@Mapper(componentModel = "spring")
public interface BookCopiesMapper {

	@Mapping(target = "ingressedAt", qualifiedByName = "defaultInstant")
	@Mapping(target = "status", constant = "Available")
	BookCopy toDomain(CreateBookCopyDTO createBookCopyDTO);

	@Named("defaultInstant")
	default Instant defaultInstant(Optional<Instant> ingressedAt) {
		return ingressedAt.orElseGet(() -> Instant.now());
	}

	@Mapping(target = "id", ignore = true)
	BookCopyEntity toEntity(BookCopy bookCopy);

	GetOneBookCopyDTO toDto(BookCopy bookCopy);
}
