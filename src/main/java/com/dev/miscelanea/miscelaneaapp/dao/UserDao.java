package com.dev.miscelanea.miscelaneaapp.dao;

import com.dev.miscelanea.miscelaneaapp.entity.Usuario;

public interface UserDao {

	public Usuario findUserByUserName(String userName);

	public void save(Usuario user);
	
}
