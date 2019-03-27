package com.yunus.webproject.service;


import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yunus.webproject.dao.RoleDao;
import com.yunus.webproject.dao.UserDao;

import com.yunus.webproject.entity.Role;
import com.yunus.webproject.entity.User;

import com.yunus.webproject.registerUser.registerUser;

@Service 
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;




	@Override
	@Transactional //it's automatically begin and end a transaction for hibernate code..
	public User getUsernameFromDatabase(String userName) {
		return userDao.getUsernameFromDatabase(userName);
	}

	@Override
	@Transactional
	public void saveUser(registerUser rUser) {
		
		User user=new User();
		
		user.setFirstName(rUser.getFirstName());
		user.setLastName(rUser.getLastName());
		user.setEmail(rUser.getEmail());
		user.setContactNumber(rUser.getContactNumber());
		user.setCountry(rUser.getCountry());
		user.setUserName(rUser.getUserName());
		user.setPassword(passwordEncoder.encode(rUser.getPassword()));
		
		
		
		//default role name=EMPLOYEE
		user.setRoles(Arrays.asList(roleDao.defaultRole("ROLE_EMPLOYEE")));
		user.setCreatedAt(new Date());
		userDao.saveUser(user);
		
	}
	
	/*
	 * In Spring Security we need to implement an interface called authentication UserDetailsService for authentication. 
	 * This interface contains the following method. UserDetails loadUserByUsername (String username); 
	 * We override this with the username parameter from the form and draw the object from our database. 
	 * In this way, Spring Security automatically performs user name, password and authorization management in our place. 
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user=userDao.getUsernameFromDatabase(userName);
		
		if (user==null) {
			throw new UsernameNotFoundException("Invalid username");
		}
		
		
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));

	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	@Transactional
	public User getUser(int theId) {
		return userDao.getUser(theId);
	}

	@Override
	@Transactional
	public void deleteUser(int theId) {
		userDao.deleteUser(theId);
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userDao.saveUser(user);
	}
}
