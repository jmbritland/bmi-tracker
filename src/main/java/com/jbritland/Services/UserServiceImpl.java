package com.jbritland.Services;

import org.springframework.stereotype.Service;

import com.jbritland.DTOs.EmailWrapper;
import com.jbritland.DTOs.NewUserDTO;
import com.jbritland.DTOs.ResponseUserDTO;
import com.jbritland.DTOs.UserAuthDTO;
import com.jbritland.DTOs.UserHeightDTO;
import com.jbritland.Entities.User;
import com.jbritland.Exceptions.EmailNotAvailableException;
import com.jbritland.Exceptions.LoginFailedException;
import com.jbritland.Exceptions.UserNotFoundException;
import com.jbritland.Repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepo uRepo;
	
	public UserServiceImpl(UserRepo uRepo) {
		this.uRepo = uRepo;
	}

	@Override
	public void checkEmailAvailability(EmailWrapper email) {
		if (uRepo.findByEmail(email.getEmail()) != null) {
			throw new EmailNotAvailableException("This email is in use by another account", email.getEmail());
		}
	}

	@Override
	public ResponseUserDTO createAccount(NewUserDTO credentials) {
		User existingUser = uRepo.findByEmail(credentials.getEmail());
		if (existingUser != null) {
			throw new RegistrationEmailNotAvailableException("The email used for registration is in use by another account", credentials.getEmail());
		}
		return ResponseUserDTO.of(uRepo.save(credentials.toUser()));
	}

	@Override
	public ResponseUserDTO login(UserAuthDTO userAuth) {
		User authenticatedUser = uRepo.findByEmailAndPassword(userAuth.getEmail(), userAuth.getPassword());
		if (authenticatedUser == null) {
			throw new LoginFailedException("The email and password did not match", userAuth.getEmail());
		}
		return ResponseUserDTO.of(authenticatedUser);
	}
	
	@Override
	public ResponseUserDTO updateHeight(UserHeightDTO user) {
		User existingUser = uRepo.findById(user.getEmail()).orElse(null);
		if (existingUser != null) {
			existingUser.setHeightCm(user.getHeightCm());
			return ResponseUserDTO.of(uRepo.save(existingUser));
		}
		throw new UserNotFoundException("The user " + user.getEmail() + " was not found", user.getEmail());
	}

}
