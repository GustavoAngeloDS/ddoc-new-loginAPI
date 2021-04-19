package com.ddoc.login.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddoc.login.facade.RegistrationFacadeImpl;
import com.ddoc.login.model.User;
import com.ddoc.login.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RegistrationFacadeImpl registrationFacadeImpl;
	
	@PostMapping
	public ResponseEntity<User> save(@Valid @RequestBody User user){
		return registrationFacadeImpl.createNewLogin(user);
	}
	
	@PutMapping
	public ResponseEntity<User> update(@Valid @RequestBody User user){
		return userService.update(user);
	}
	
	@PutMapping("/updatePassword")
	public ResponseEntity<User> updatePassword(@Valid @RequestBody User user){
		return userService.updatePassword(user);
	}	
	
	@DeleteMapping
	public ResponseEntity<User> delete(@Valid @RequestBody User user){
		return userService.delete(user);
	}
	
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable(value="id") Long userId) {
		return userService.findById(userId);
	}
}
