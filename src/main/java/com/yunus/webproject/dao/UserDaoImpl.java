package com.yunus.webproject.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yunus.webproject.entity.User;

@Repository // Specialized annotation for data access object
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public User getUsernameFromDatabase(String userName) {

		// get the current hibernate session..-Session is main object used to
		// save/retrieve objects
		Session session = factory.getCurrentSession();

		// retrieve username from database
		Query<User> foundQuery = session.createQuery("from User where userName=:uN", User.class);

		foundQuery.setParameter("uN", userName);

		/*
		 * getSingleResult () does not return a List in contrast to the getResultList () method.
		A single result of the query result will be return. 
		using the getSingleResult method If the result cannot be found, the exception is thrown. 
		Or, if more than one result is found in this case will also throw the exception.
		 */

		User theUser = null;

		try {
			theUser = foundQuery.getSingleResult();

		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public void saveUser(User user) {

		Session session = factory.getCurrentSession();
		user.setCreatedAt(new Date());

		session.saveOrUpdate(user);

	}

	@Override
	public List<User> getUsers() {

		Session session = factory.getCurrentSession();

		// create query..sort by lastname
		Query<User> theQuery = session.createQuery("from User order by lastName", User.class);

		// execute query and get result list
		List<User> users = theQuery.getResultList();

		return users;
	}

	@Override
	public User getUser(int theId) {

		Session session = factory.getCurrentSession();

		User theUser = session.get(User.class, theId);
		Hibernate.initialize(theUser.getInformations());
		return theUser;
	}

	@Override
	public void deleteUser(int theId) {

		Session session = factory.getCurrentSession();

		Query theQuery = session.createQuery("delete from User where id=:userId");
		theQuery.setParameter("userId", theId);

		theQuery.executeUpdate();

	}

}