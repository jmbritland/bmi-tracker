package com.jbritland.DTOs;

import java.sql.Date;

import com.jbritland.Entities.User;
import com.jbritland.Entities.Weight;
import com.jbritland.Entities.WeightId;
import com.jbritland.Exceptions.InvalidDateException;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @NoArgsConstructor
public class NewWeightDTO {

	@NotBlank(message = "Email is required")
	@Getter
	private String email;
    @NotBlank(message = "Date is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must be in the format YYYY-MM-DD")
    private String weighDate;
	@DecimalMin(value="2.0", inclusive = true, message = "Weight must be at least 2")
	@DecimalMax(value="640.0", inclusive = true, message = "Weight must be at most 640")
	double weightKg;
	
	public Weight toWeight() {
		try {
			Date sqlDate = Date.valueOf(this.weighDate);
			return new Weight(new WeightId(new User(this.email), sqlDate), this.weightKg);
		}
		catch (IllegalArgumentException e) {
			throw new InvalidDateException("Invalid date; date must be in the format 'YYYY-MM-DD'", weighDate);
		}
	}
	
}
