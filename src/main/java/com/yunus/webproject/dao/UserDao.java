package com.yunus.webproject.dao;

import java.util.List;

import com.yunus.webproject.entity.User;

public interface UserDao {

	public List<User> getUsers();

	public User getUsernameFromDatabase(String userName);

	public User getUser(int theId);

	public void saveUser(User user);

	public void deleteUser(int theId);

}
