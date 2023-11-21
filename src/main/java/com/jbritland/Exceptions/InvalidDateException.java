package com.jbritland.Exceptions;

import lombok.Getter;

public class InvalidDateException extends RuntimeException {
	
	@Getter
	private String dateString;

	public InvalidDateException(String message, String dateString) {
		super(message);
		this.dateString = dateString;
	}
	
}
