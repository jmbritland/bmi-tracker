package com.jbritland.Exceptions;

import lombok.Getter;

public class EmailNotAvailableException extends RuntimeException {
	
	@Getter
	private String email;

	public EmailNotAvailableException(String message, String email) {
		super(message);
		this.email = email;
	}
	
}
