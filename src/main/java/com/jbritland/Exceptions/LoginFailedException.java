package com.jbritland.Exceptions;

import lombok.Getter;

public class LoginFailedException extends RuntimeException {
	
	@Getter
	private String email;

	public LoginFailedException(String message, String email) {
		super(message);
		this.email = email;
	}
	
}
