package com.yunus.webproject.dao;

import com.yunus.webproject.entity.Role;

public interface RoleDao {
	
	public Role getRoleFromDatabase(String theRoleName);
	
	public Role defaultRole(String defaultRole);

}
