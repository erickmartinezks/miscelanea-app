package com.dev.miscelanea.miscelaneaapp.dao;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.miscelanea.miscelaneaapp.entity.Rol;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Rol findRoleByName(String theRoleName) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Rol> theQuery = currentSession.createQuery("FROM Rol WHERE nombre=:roleName", Rol.class);
		theQuery.setParameter("roleName", theRoleName);
		
		Rol theRole = null;
		
		try {
			theRole = theQuery.getSingleResult();
		}catch(Exception err) {
			theRole = null;
		}
		
		return theRole;
	}

}
