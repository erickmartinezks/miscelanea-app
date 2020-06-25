package com.dev.miscelanea.miscelaneaapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.miscelanea.miscelaneaapp.entity.Producto;

@Repository
public class ProductoDAOImpl implements ProductoDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Producto producto) {

		Session currentSession = entityManager.unwrap(Session.class);

		try {
		currentSession.saveOrUpdate(producto);
		}catch(Exception err) {
			System.out.println("ERROR DAO::::::::::::::::::::::" + err.getMessage());
		}
	}

	@Override
	public List<Producto> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Producto> theQuery = currentSession.createQuery("FROM Producto", Producto.class);
		
		List<Producto> productos = theQuery.getResultList();
		System.out.println("Tamaño de productos: " + productos.size());
		return productos;
	}

	@Override
	public Producto findById(int id) {

		Session currentSession = entityManager.unwrap(Session.class);
			
		Query<Producto> theQuery = currentSession.createQuery("FROM Producto WHERE id=:id", Producto.class);
		theQuery.setParameter("id", id);
		
		Producto tempProducto = theQuery.getSingleResult();
		
		return tempProducto;
	}

	@Override
	public void deleteProductoById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("DELETE FROM Producto WHERE id=:id");
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();
		
	}

	
	
	
	
	
	
	
	
	
}
