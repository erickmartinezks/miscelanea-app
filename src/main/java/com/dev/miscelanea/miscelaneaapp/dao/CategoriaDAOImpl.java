package com.dev.miscelanea.miscelaneaapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.miscelanea.miscelaneaapp.entity.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Categoria categoria) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Categoria> getAllCategorias() {

		List<Categoria> categorias = new ArrayList<>();
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Categoria> theQuery = currentSession.createQuery("FROM Categoria", Categoria.class);
		
		categorias = theQuery.getResultList();
		
		return categorias;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Categoria findCategoriaById(int id) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Categoria tempCategoria = currentSession.get(Categoria.class, id);
		System.out.println("Categoria encontrada::::: " + tempCategoria);
		return tempCategoria;
	}

}
