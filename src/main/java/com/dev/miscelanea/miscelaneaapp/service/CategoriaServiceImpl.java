package com.dev.miscelanea.miscelaneaapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.miscelanea.miscelaneaapp.dao.CategoriaDAO;
import com.dev.miscelanea.miscelaneaapp.dao.ProductoDAO;
import com.dev.miscelanea.miscelaneaapp.entity.Categoria;
import com.dev.miscelanea.miscelaneaapp.entity.Producto;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaDAO categoriaDAO;
	
	@Autowired
	ProductoDAO productoDAO;
	
	@Transactional
	@Override
	public Categoria findById(int id) {
		Categoria tempCategoria = categoriaDAO.findById(id);
		
		return tempCategoria;
	}

	@Transactional
	@Override
	public List<Categoria> findAll() {

		List<Categoria> categorias = categoriaDAO.findAll();
		
		if(categorias == null) {
			throw new RuntimeException("No se encontraron categorias.");
		}
		
		return categorias;
	}

	@Transactional
	@Override
	public List<Producto> findProductosByIdCategoria(int id) {
		
		List<Producto> productos = categoriaDAO.findProductosByIdCategoria(id);
		
		return productos;
	}
	
	@Transactional
	@Override
	public void save(Categoria categoria) {
		
		categoriaDAO.save(categoria);
		
	}
	
	@Transactional
	@Override
	public void deleteById(int id) {

		categoriaDAO.deleteById(id);
		
	}

}
