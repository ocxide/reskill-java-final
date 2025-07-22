package com.ocxide.booksservice.bookeditions.infrastructure;

import org.mapstruct.Mapper;

import com.ocxide.booksservice.bookeditions.infrastructure.http.ISBNDto;

@Mapper(componentModel = "spring")
public abstract class ISBNMapper {
	public String toPrimitive(ISBNDto isbn) {
		return isbn.value();
	}
	
}
