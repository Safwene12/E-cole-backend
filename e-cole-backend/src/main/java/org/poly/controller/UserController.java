package org.poly.controller;

import java.util.List;
import java.util.Optional;

import org.poly.entities.User;
import org.poly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/user/{id}")
	public User getUserById(@PathVariable Long id)
	{
		User user = userRepository.findById(id).get();	
		
		return user;
	}
	@RequestMapping("/users")
	public List<User> getAll()
	{
		List<User> users = userRepository.findAll();
		
		return users;
	}

}
