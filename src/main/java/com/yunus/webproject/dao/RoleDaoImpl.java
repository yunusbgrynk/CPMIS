package com.yunus.webproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yunus.webproject.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	SessionFactory factory;

	@Override
	public Role getRoleFromDatabase(String theRoleName) {

		Session session = factory.getCurrentSession();

		Query<Role> foundQuery = session.createQuery("from Role where name=:rN", Role.class);

		foundQuery.setParameter("rN", theRoleName);

		Role theRole = null;

		try {
			theRole = foundQuery.getSingleResult();

		} catch (Exception e) {
			theRole = null;
		}

		return theRole;
	}

	@Override
	public Role defaultRole(String defaultRole) {

		Role theRole = new Role("ROLE_EMPLOYEE");

		return theRole;
	}
}