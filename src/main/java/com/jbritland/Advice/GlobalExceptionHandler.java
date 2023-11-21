package com.jbritland.Advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jbritland.DTOs.ErrorResponse;
import com.jbritland.Exceptions.EmailNotAvailableException;
import com.jbritland.Exceptions.InvalidDateException;
import com.jbritland.Exceptions.LoginFailedException;
import com.jbritland.Exceptions.UserNotFoundException;
import com.jbritland.Services.RegistrationEmailNotAvailableException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {UserNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException e) {
    	logger.error("User {} not found", e.getEmail(), e);
        return new ErrorResponse("User not found", e.getMessage());
    }
    
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException e) {
    	BindingResult bindingResult = e.getBindingResult();

        // Log the details of the validation errors
        logger.error("Validation error in method arguments: {}", e.getMessage(), e);
        bindingResult.getFieldErrors().forEach(error ->
            logger.error("Field error in object '{}', field '{}': {}",
                error.getObjectName(), error.getField(), error.getDefaultMessage()));

        return new ErrorResponse("Invalid request parameters", e.getMessage());
    }
    
    @ExceptionHandler(InvalidDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidDateException(InvalidDateException e) {
    	logger.error("Cannot parse date from '{}'", e.getDateString(), e);
    	return new ErrorResponse("Invalid request parameters", e.getMessage());
    }
	
    @ExceptionHandler(LoginFailedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleLoginFailedException(LoginFailedException e) {
    	logger.info("Login failed for user {}", e.getEmail(), e);
    	return new ErrorResponse("Login failed", e.getMessage());
    }
    
    @ExceptionHandler(EmailNotAvailableException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleEmailNotAvailableException(EmailNotAvailableException e) {
    	if (e instanceof RegistrationEmailNotAvailableException) {
    		logger.error("Attempted registration with unavailable email {}", e.getEmail(), e);
    	}
    	else {
    		logger.info("Email {} is in use by an account", e.getEmail(), e);
    	}
    	return new ErrorResponse("Email not available", e.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGenericException(Exception e) {
    	logger.error("An unexpected error occurred", e);
        return new ErrorResponse("An unexpected error occurred", e.getMessage());
    }
    
}