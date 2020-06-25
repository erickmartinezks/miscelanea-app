package com.dev.miscelanea.miscelaneaapp.dao;

import com.dev.miscelanea.miscelaneaapp.entity.Rol;

public interface RoleDao {

	public Rol findRoleByName(String theRoleName);
	
}
