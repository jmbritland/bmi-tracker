package com.jbritland.DTOs;

import com.jbritland.Entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class ResponseUserDTO {
	
	private String email;
	private double heightCm;
	
	public static ResponseUserDTO of(User user) {
		if (user == null) {
			return null;
		}
		return new ResponseUserDTO(user.getEmail(), user.getHeightCm());
	}
	
}
