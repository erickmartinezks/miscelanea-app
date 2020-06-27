package com.dev.miscelanea.miscelaneaapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.miscelanea.miscelaneaapp.entity.Categoria;
import com.dev.miscelanea.miscelaneaapp.entity.Producto;

@Repository
public class ProductoDAOImpl implements ProductoDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Producto> findAll() {
		
		List<Producto> productos = null;
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Producto> theQuery = currentSession.createQuery("FROM Producto", Producto.class);
		
		try {	
			productos = theQuery.getResultList();
		}catch(Exception err) {
			productos = null;
		}

		return productos;
	}

	@Override
	public Producto findById(int id) {
		Producto tempProducto = null;
		Session currentSession = entityManager.unwrap(Session.class);
			
		Query<Producto> theQuery = currentSession.createQuery("FROM Producto WHERE id=:id", Producto.class);
		theQuery.setParameter("id", id);
		
		try {
			tempProducto = theQuery.getSingleResult();			
		}catch(Exception err) {
			tempProducto = null;
		}
		
		return tempProducto;
	}
	
	@Override
	public Producto findByCodigo(String codigo) {
		Producto oProducto = null;
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Producto> theQuery = currentSession.createQuery("FROM Producto WHERE codigo=:codigo", Producto.class);
		theQuery.setParameter("codigo", codigo);
		
		try {
			oProducto = theQuery.getSingleResult();
		}catch(Exception err) {
			oProducto = null;
		}
		
		return oProducto;
	}

	@Override
	public void save(Producto producto) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(producto);
		
	}
	
	@Override
	public void deleteProductoById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("DELETE FROM Producto WHERE id=:id");
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();
		
	}



	
	
	
	
	
	
	
	
	
}
