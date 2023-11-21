package com.jbritland.Exceptions;

import lombok.Getter;

public class UserNotFoundException extends RuntimeException {
	
	@Getter
	private String email;

	public UserNotFoundException(String message, String email) {
		super(message);
		this.email = email;
	}

}
