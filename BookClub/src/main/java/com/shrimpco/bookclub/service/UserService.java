package com.shrimpco.bookclub.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.shrimpco.bookclub.model.User;
import com.shrimpco.bookclub.repository.UserRepository;


@Service
public class UserService {

	//setup autowired if necessary
	@Autowired
	private UserRepository userRepository;
	
	//create, find all, find 1, delete
	
	public void createUser(User user) {
		userRepository.save(user);
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
	
	public User registerUser(User newUser, BindingResult bindingResult) {
		
		//checking if pw equals confirm
		if(!newUser.getPassword().equals(newUser.getConfirm_password())) {
			System.out.println("unsuccessful register - password mismatch");
			bindingResult.rejectValue("confirm_password", "Matches", "Password mismatch!");
			return null;
		}
		
		//checking if db req met
		if(bindingResult.hasErrors()) {
			System.out.println("unsuccessful register - table req not met");
			return null;
		}
		
		//checking if email exists
		User potentialUser = singleUserByLogin(newUser.getEmail());
		if(potentialUser != null){
			System.out.println("unsuccessful register - email already exists");
			bindingResult.rejectValue("email", "In Use", "The email already exists in db!");
			return null;
		} 
		else {
			String hashedPassword = BCrypt.hashpw( newUser.getPassword(), BCrypt.gensalt() );
			newUser.setPassword(hashedPassword);
			return newUser;
		}
	}
	
	public User login(User user, BindingResult bindingResult) {
		
		//checking if email exists
		User currentUser = singleUserByLogin(user.getEmail());
		if(currentUser != null) {
			
			//checking pw against db
			if(BCrypt.checkpw(user.getPassword(), currentUser.getPassword() ) ) {
					System.out.println("successful login");
					return currentUser;
			}
			else {
				System.out.println("unsuccessful login - password");
				bindingResult.rejectValue("password", "Incorrect", "Password not correct!");
				return null;
			}
		} 
		else {
			System.out.println("unsuccessful login - email");
			bindingResult.rejectValue("email", "Incorrect", "email not correct!");
			return null;
		}
	}
}