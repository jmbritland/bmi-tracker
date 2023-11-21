package com.jbritland.DTOs;

import com.jbritland.Entities.User;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @NoArgsConstructor
public class NewUserDTO {

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	@Getter
	private String email;
	@NotBlank(message = "Password is required")
	@Size(min = 6, max = 50, message = "Password must be between 6 and 50 characters long")
	private String password;
	@DecimalMin(value="50.0", inclusive = true, message = "Height must be at least 50cm")
	@DecimalMax(value="280.0", inclusive = true, message = "Height must be at most 280cm")
	private double heightCm;
	
	public User toUser() {
		return new User(this.email, this.password, this.heightCm);
	}
	
}
