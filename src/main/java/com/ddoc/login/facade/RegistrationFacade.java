package com.ddoc.login.facade;

import org.springframework.http.ResponseEntity;

import com.ddoc.login.model.User;

public interface RegistrationFacade {

	ResponseEntity<User> createNewLogin(User user);
}
