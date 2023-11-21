package com.jbritland.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Setter @Getter
public class UserAuthDTO {

	@NotBlank(message = "Email is required")
	private String email;
	private String password;

}
