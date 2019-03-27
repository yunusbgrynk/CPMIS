package com.yunus.webproject.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.yunus.webproject.entity.User;
import com.yunus.webproject.registerUser.registerUser;

public interface UserService extends UserDetailsService {

	public List<User> getUsers();

	User getUsernameFromDatabase(String userName);

	void saveUser(registerUser rUser);

	public User getUser(int theId);

	public void deleteUser(int theId);

	public void saveUser(User user);

}