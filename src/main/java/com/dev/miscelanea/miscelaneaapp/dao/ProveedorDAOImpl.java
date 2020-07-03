package com.dev.miscelanea.miscelaneaapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.miscelanea.miscelaneaapp.entity.Proveedor;

@Repository
public class ProveedorDAOImpl implements ProveedorDAO {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Proveedor> findAll() {
		
		List<Proveedor> proveedores = null;
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Proveedor> theQuery = currentSession.createQuery("FROM Proveedor", Proveedor.class);
		
		try {
			proveedores = theQuery.getResultList();
		}catch(Exception err) {
			proveedores = null;
		}
		
		return proveedores;
	}

	@Override
	public Proveedor findById(int id) {
		
		Proveedor proveedor = null;
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Proveedor> theQuery = currentSession.createQuery("FROM Proveedor WHERE id=:id", Proveedor.class);
		theQuery.setParameter("id", id);
		
		try {
			proveedor = theQuery.getSingleResult();
		}catch(Exception err) {
			proveedor = null;
		}
		
		return proveedor;
	}

	@Override
	public void save(Proveedor proveedor) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(proveedor);

	}

	@Override
	public void deleteById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("DELETE FROM Proveedor WHERE id=:id");
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();

	}

}
