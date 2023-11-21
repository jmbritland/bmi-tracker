package com.jbritland.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbritland.DTOs.EmailWrapper;
import com.jbritland.DTOs.NewUserDTO;
import com.jbritland.DTOs.ResponseUserDTO;
import com.jbritland.DTOs.UserAuthDTO;
import com.jbritland.Services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private final UserService uService;
	
	public UserController(UserService uService) {
		this.uService = uService;
	}
	
	@PostMapping("/isEmailAvailable")
	public ResponseEntity<String> isEmailAvailable(@RequestBody EmailWrapper email) {
		uService.checkEmailAvailability(email);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@PostMapping("/login")
	public ResponseUserDTO login(@RequestBody @Valid UserAuthDTO credentials) {
		return uService.login(credentials);
	}
	
	@PostMapping("/createAccount")
	public ResponseUserDTO createAccount(@RequestBody @Valid NewUserDTO user) {
		return uService.createAccount(user);
	}
	
}
