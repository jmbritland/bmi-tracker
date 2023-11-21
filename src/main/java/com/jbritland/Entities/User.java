package com.jbritland.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class User {

	@Id
	private String email;
	private String password;
	private double heightCm = 0;
	
	public User(String email) {
		this.email = email;
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User(String email, double heightCm) {
		this.email = email;
		this.heightCm = heightCm;
	}
	
}
