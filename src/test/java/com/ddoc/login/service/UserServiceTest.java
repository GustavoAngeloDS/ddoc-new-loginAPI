package com.ddoc.login.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ddoc.login.enums.UserSituation;
import com.ddoc.login.model.User;
import com.ddoc.login.repository.UserRepository;
import com.ddoc.login.service.UserService;
import com.ddoc.login.util.EncryptionAlgorithm;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	/* Repository used only to validate Service actions */
	@Autowired
	private UserRepository userRepository;
	
	/* Test variables and objects */
	private static String newUserTestPassword = "teste123";
	private static User newUserTest = new User("Gustavo", "Angelo da Silva", "gustavosilvaangelo@gmail.com", newUserTestPassword, UserSituation.ACTIVE, "20210417"); 
		
	@Test
	@Order(1)
	public void saveTest() {				
		userService.save(newUserTest);
				
		assertTrue(userRepository.findById(newUserTest.getId()).isPresent());
		assertEquals(userRepository.findById(newUserTest.getId()).get().getPassword(), EncryptionAlgorithm.doCrypto(newUserTestPassword));
	}
	
	@Test
	@Order(2)
	public void findByIdTest() {	
		assertTrue(userService.findById(newUserTest.getId()) != null);
		assertEquals(userService.findById(newUserTest.getId()).getBody().getId(), newUserTest.getId());
	}
	
	@Test
	@Order(3)
	public void updateTest() {
		newUserTest.setEmail("emailAlteradoTeste@hotmail.com.br");
		userService.update(newUserTest);
		
		assertEquals(newUserTest.getEmail(), userRepository.findById(newUserTest.getId()).get().getEmail());
	}
	
	@Test
	@Order(4)
	public void updatePasswordTest() {
		String newUserTestPasswordLocal = "senhaAlterada098";
		newUserTest.setPassword(newUserTestPasswordLocal);
		userService.updatePassword(newUserTest);
		
		assertEquals(newUserTest.getPassword(), EncryptionAlgorithm.doCrypto(newUserTestPasswordLocal));
	}
	
	@Test
	@Order(5)
	public void deleteTest() {
		Long newUserTestID = newUserTest.getId();
		userService.delete(newUserTest);
		
		assertFalse(userRepository.findById(newUserTestID).isPresent());
	}
}
