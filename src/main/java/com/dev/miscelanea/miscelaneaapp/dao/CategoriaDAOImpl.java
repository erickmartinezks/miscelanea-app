package com.dev.miscelanea.miscelaneaapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.miscelanea.miscelaneaapp.entity.Categoria;
import com.dev.miscelanea.miscelaneaapp.entity.Producto;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Categoria findById(int id) {

		Categoria tempCategoria = null; 
		Session currentSession = entityManager.unwrap(Session.class);
		
		try {	
			tempCategoria = currentSession.get(Categoria.class, id);
		}catch(Exception err) {
			tempCategoria = null;
		}
		
		return tempCategoria;
	}
	
	@Override
	public List<Categoria> findAll() {

		List<Categoria> categorias = new ArrayList<>();
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Categoria> theQuery = currentSession.createQuery("FROM Categoria", Categoria.class);
		
		try {	
			categorias = theQuery.getResultList();
		}catch(Exception err) {
			categorias = null;
		}
		
		return categorias;
	}
	
	@Override
	public void save(Categoria categoria) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(categoria);		
		
	}

	@Override
	public void deleteById(int id) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("DELETE FROM Categoria WHERE id=:id");
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();
	}

	@Override
	public List<Producto> findProductosByIdCategoria(int id) {

		List<Producto> productos = null; 
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Producto> theQuery = currentSession.createQuery("FROM Producto WHERE id_categoria=:id_categoria", Producto.class);
		theQuery.setParameter("id_categoria", id);
		
		try {	
			productos = theQuery.getResultList();
		}catch(Exception err) {
			productos = null;
		}
		
		return productos;
	}
	
}
