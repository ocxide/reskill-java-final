package com.ocxide.booksservice.bookeditions.infrastructure.http;

public record GetBookEditionDTO(
		Long id,
		String title,
		String author,
		String isbn) {
}
