package com.jbritland.DTOs;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @NoArgsConstructor @Getter
public class UserHeightDTO {
	
	@NotBlank(message = "Email is required")
	private String email;
	@DecimalMin(value="50.0", inclusive = true, message = "Height must be at least 50cm")
	@DecimalMax(value="280.0", inclusive = true, message = "Height must be at most 280cm")
	private double heightCm;
	
}
