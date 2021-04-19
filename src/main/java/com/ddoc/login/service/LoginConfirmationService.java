package com.ddoc.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ddoc.login.model.LoginConfirmation;
import com.ddoc.login.repository.LoginConfirmationRepository;

@Service
public class LoginConfirmationService {

	@Autowired
	private LoginConfirmationRepository loginConfirmationRepository;
	
	public ResponseEntity<LoginConfirmation> findById(Long id) {
		Optional<LoginConfirmation> loginConfirmation = loginConfirmationRepository.findById(id);
		
		if(loginConfirmation.isPresent())
			return new ResponseEntity<LoginConfirmation>(loginConfirmation.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<LoginConfirmation> save(LoginConfirmation loginConfirmation) {
		LoginConfirmation newLoginConfirmationCreated = loginConfirmationRepository.save(loginConfirmation);
		
		if(loginConfirmationRepository.findById(newLoginConfirmationCreated.getId()).isPresent())
			return new ResponseEntity<LoginConfirmation>(HttpStatus.CREATED);
		else
			return new ResponseEntity<LoginConfirmation>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
