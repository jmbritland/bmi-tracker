package com.jbritland.Services;

import com.jbritland.DTOs.EmailWrapper;
import com.jbritland.DTOs.NewUserDTO;
import com.jbritland.DTOs.ResponseUserDTO;
import com.jbritland.DTOs.UserAuthDTO;
import com.jbritland.DTOs.UserHeightDTO;
import com.jbritland.Exceptions.EmailNotAvailableException;
import com.jbritland.Exceptions.LoginFailedException;
import com.jbritland.Exceptions.UserNotFoundException;

public interface UserService {
	
	public void checkEmailAvailability(EmailWrapper email);
	public ResponseUserDTO createAccount(NewUserDTO user);
	public ResponseUserDTO login(UserAuthDTO userAuth);
	public ResponseUserDTO updateHeight(UserHeightDTO user);

}
