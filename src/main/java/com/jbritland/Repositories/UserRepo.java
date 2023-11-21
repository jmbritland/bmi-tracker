package com.jbritland.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jbritland.Entities.User;

public interface UserRepo extends JpaRepository<User, String> {

	public User findByEmail(String email);
	public User findByEmailAndPassword(String email, String password);
	
}
