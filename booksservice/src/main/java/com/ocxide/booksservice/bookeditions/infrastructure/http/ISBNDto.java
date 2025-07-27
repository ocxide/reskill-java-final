package com.ocxide.booksservice.bookeditions.infrastructure.http;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ISBNDto(
	@NotBlank(message = "ISBN is required")
	@Size(max = 17, min = 17, message = "ISBN should be 17 characters long")
	@Pattern(regexp = "\\d{3}-\\d{1}-\\d{3}-\\d{5}-\\d{1}", message = "Invalid ISBN")
	String value) {

	@JsonValue
	public String getValue() {
		return value;
	}

	@JsonCreator
	public static ISBNDto of(String value) {
		return new ISBNDto(value);
	}
}
