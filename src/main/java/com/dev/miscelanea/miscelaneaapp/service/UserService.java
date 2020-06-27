package com.dev.miscelanea.miscelaneaapp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.dev.miscelanea.miscelaneaapp.entity.Usuario;
import com.dev.miscelanea.miscelaneaapp.uiconstraints.UIUser;

public interface UserService extends UserDetailsService{
	
	public Usuario findByUserName(String userName);
	
	public void save(UIUser crmUser);

}
