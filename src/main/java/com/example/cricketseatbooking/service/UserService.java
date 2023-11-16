package com.example.cricketseatbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricketseatbooking.entities.User;
import com.example.cricketseatbooking.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public String addUser(User user) {
		
		User u1 = userRepository.save(user);
		
		if(u1 != null)
			return "User " + u1.getUser_id() +" successfully created";
		else
		return null;
	}
	public User getUser(Long user_id) {
		User u2 = userRepository.findById(user_id).get();
		return u2;
	}
	
	public String updateStudent(Long user_id, User newUser) {
		User u1 = userRepository.findById(user_id).get();
		u1.setUsername(newUser.getUsername());	
		u1 = userRepository.save(u1);
			
			if(u1 != null)
				return "User " + u1.getUser_id() + ", " + u1.getUsername() + " successfully updated";
			else
			return null;
		}
	
	public String deleteUser(Long user_id) {
		
		 userRepository.deleteById(user_id);
		
		if(user_id == null) {
			return " User with Id " + user_id +" not found";
		} else {
			return "User with Id " + user_id +" deleted successfully";
		}
	}
}
