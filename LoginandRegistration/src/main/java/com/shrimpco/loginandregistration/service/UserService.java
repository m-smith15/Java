package com.shrimpco.loginandregistration.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrimpco.loginandregistration.model.User;
import com.shrimpco.loginandregistration.repository.UserRepository;

@Service
public class UserService {

	//setup autowired if necessary
	@Autowired
	private UserRepository userRepository;
	
	//create, find all, find 1, delete
	
	public User createUser(User user) {
		String hashedPassword = BCrypt.hashpw( user.getPassword(), BCrypt.gensalt() );
		user.setPassword(hashedPassword);
		return userRepository.save(user);
	}
	
	public List<User> allUsers(){
		return userRepository.findAll();
	}
	
	public User singleUser(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
			if(optionalUser.isPresent()) {
				return optionalUser.get();
			} else {
				return null;
			}
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public User singleUserByLogin(String email) {
		Optional<User> optionalUser = userRepository.findByEmail(email);
			if(optionalUser.isPresent()) {
				return optionalUser.get();
			} else {
				return null;
			}
	}
	
}
