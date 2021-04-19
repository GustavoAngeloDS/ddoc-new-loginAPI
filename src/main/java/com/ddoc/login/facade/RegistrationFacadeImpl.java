package com.ddoc.login.facade;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ddoc.login.enums.LoginConfirmationSituation;
import com.ddoc.login.model.LoginConfirmation;
import com.ddoc.login.model.User;
import com.ddoc.login.service.LoginConfirmationService;
import com.ddoc.login.service.UserService;

@Service
public class RegistrationFacadeImpl implements RegistrationFacade {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginConfirmationService loginConfirmationService;
	
	@Override
	public ResponseEntity<User> createNewLogin(User user) {
		ResponseEntity<User> userCreated = userService.save(user);
		
		LoginConfirmation loginConfirmation = new LoginConfirmation(userCreated.getBody().getId(), "ABC", LoginConfirmationSituation.CREATED, LocalDateTime.now().toString());
		loginConfirmationService.save(loginConfirmation);
		
		return userCreated;
	}
}
