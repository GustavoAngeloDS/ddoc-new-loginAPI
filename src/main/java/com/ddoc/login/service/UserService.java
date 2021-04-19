package com.ddoc.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ddoc.login.enums.UserSituation;
import com.ddoc.login.model.User;
import com.ddoc.login.repository.UserRepository;
import com.ddoc.login.util.EncryptionAlgorithm;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
		
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public ResponseEntity<User> findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent())
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<User> save(User user) {
		user.setPassword(EncryptionAlgorithm.doCrypto(user.getPassword()));
		User newUserCreated = userRepository.save(user);
						
		if(userRepository.findById(newUserCreated.getId()).isPresent())
			return new ResponseEntity<User>(newUserCreated, HttpStatus.CREATED);
		else
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ResponseEntity<User> delete(User user){
		Optional<User> userToDelete = userRepository.findById(user.getId());
		
		if(userToDelete.isPresent()) {
			userRepository.delete(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<User> update(User user){
		Optional<User> oldUser = userRepository.findById(user.getId());
		
		if(oldUser.isPresent()) {
			return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<User> updatePassword(User user){
		if(userRepository.findById(user.getId()).isPresent()) { 
			user.setPassword(EncryptionAlgorithm.doCrypto(user.getPassword()));			
			return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<User> updateUserSituaction(User user, UserSituation newUserSituation){
		if(userRepository.findById(user.getId()).isPresent()) {
			user.setUserSituation(newUserSituation);
			userRepository.save(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
