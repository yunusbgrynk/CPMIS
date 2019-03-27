package com.yunus.webproject.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yunus.webproject.entity.User;

import com.yunus.webproject.service.UserService;

@RestController
@RequestMapping("/api")
public class HomeRestController {

	@Autowired 
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) {
		User theUser=userService.getUser(userId);
		
		if (theUser==null) {
			throw new UserNotFoundException("Intended User Id not found :"+userId);
		}
		
		return theUser;
	}
}
