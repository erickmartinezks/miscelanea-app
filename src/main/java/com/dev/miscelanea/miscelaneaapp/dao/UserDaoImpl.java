package com.dev.miscelanea.miscelaneaapp.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.miscelanea.miscelaneaapp.entity.Usuario;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Usuario findUserByUserName(String userName) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Usuario> theQuery = currentSession.createQuery("FROM Usuario WHERE username=:username", Usuario.class);
		theQuery.setParameter("username", userName);
		
		Usuario theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		}catch(Exception err) {
			theUser = null;
		}
		
		return theUser;
	}

	@Override
	public void save(Usuario user) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(user);
	}

}
