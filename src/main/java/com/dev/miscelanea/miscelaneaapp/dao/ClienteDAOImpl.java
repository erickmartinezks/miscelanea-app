package com.dev.miscelanea.miscelaneaapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.dev.miscelanea.miscelaneaapp.entity.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

	EntityManager entityManager;
	
	public ClienteDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Cliente> findAll() {

		List<Cliente> clientes = null;
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Cliente> theQuery = currentSession.createQuery("FROM Cliente WHERE activo=1", Cliente.class);
		
		try{
			clientes = theQuery.getResultList();
		}catch(Exception err) {
			clientes = null;
		}
		
		return clientes;
	}

	@Override
	public Cliente findById(int id) {
		
		Cliente cliente = null;
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Cliente> theQuery = currentSession.createQuery("FROM Cliente WHERE id=:id", Cliente.class);
		theQuery.setParameter("id", id);
		
		try {
			cliente = theQuery.getSingleResult();
		}catch(Exception err) {
			cliente = null;
		}
		
		return cliente;
	}

	@Override
	public void save(Cliente cliente) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(cliente);

	}

	@Override
	public void deleteById(int id) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("DELETE FROM Cliente WHERE id=:id");
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();

	}

	@Override
	public void deactivateById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("UPDATE Cliente SET activo=0 WHERE id=:id");
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();
		
	}

}
