package com.jbritland.Services;

import com.jbritland.Exceptions.EmailNotAvailableException;

public class RegistrationEmailNotAvailableException extends EmailNotAvailableException {

	public RegistrationEmailNotAvailableException(String message, String email) {
		super(message, email);
	}
	
}
