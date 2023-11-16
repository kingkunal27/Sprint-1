package com.example.cricketseatbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricketseatbooking.entities.User;
import com.example.cricketseatbooking.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
	
	return userService.addUser(user);
    
	}
	
	@GetMapping("/getUser/{user_id}")
	public User getUser(@PathVariable Long user_id) {
		return userService.getUser(user_id);
	}
	
	@PutMapping("/updateUser/{user_id}")
	public String updateUser(@PathVariable Long user_id, @RequestBody User newUser) {
		return userService.updateStudent(user_id, newUser);
	}
	
	@DeleteMapping("/deleteUser/{user_id}")
	public String deleteUser(@PathVariable Long user_id) {
		String delmsg = userService.deleteUser(user_id);
		
		return delmsg;
	}
	
}