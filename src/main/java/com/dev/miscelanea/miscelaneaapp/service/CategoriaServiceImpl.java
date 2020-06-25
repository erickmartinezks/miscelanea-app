package com.dev.miscelanea.miscelaneaapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.miscelanea.miscelaneaapp.dao.CategoriaDAO;
import com.dev.miscelanea.miscelaneaapp.entity.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaDAO categoriaDAO;
	
	@Override
	public void save(Categoria categoria) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public List<Categoria> getAllCategorias() {

		List<Categoria> categorias = categoriaDAO.getAllCategorias();
		
		if(categorias == null) {
			throw new RuntimeException("No se encontraron categorias.");
		}
		
		return categorias;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

}
