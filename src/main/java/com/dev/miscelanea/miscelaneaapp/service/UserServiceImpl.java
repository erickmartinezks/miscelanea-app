package com.dev.miscelanea.miscelaneaapp.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.miscelanea.miscelaneaapp.dao.RoleDao;
import com.dev.miscelanea.miscelaneaapp.dao.UserDao;
import com.dev.miscelanea.miscelaneaapp.entity.Rol;
import com.dev.miscelanea.miscelaneaapp.entity.Usuario;
import com.dev.miscelanea.miscelaneaapp.user.CrmUser;

@Service
public class UserServiceImpl implements UserService {

	// need to inject user dao
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userDao.findUserByUserName(username);
		
		if(user == null) {
			throw new RuntimeException("Nombre de usuario o contraseña incorrectos.");
			//throw new UsernameNotFoundException("Nombre de usuario o contraseña incorrectos.");
		}
		System.out.println("Los roles: " + user.getRoles());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
				mapRolesToAuthorities(user.getRoles()));
	}

	@Transactional
	@Override
	public Usuario findByUserName(String userName) {

		return userDao.findUserByUserName(userName);
	}

	@Override
	public void save(CrmUser crmUser) {

		Usuario user = new Usuario();
		// assign user details to the user object
		user.setUsername(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));

		// give user default role of "GENERAL"
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_GENERAL")));

		userDao.save(user);
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}
	

}
