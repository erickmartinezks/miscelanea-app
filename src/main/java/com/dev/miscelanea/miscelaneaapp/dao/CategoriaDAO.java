package com.dev.miscelanea.miscelaneaapp.dao;

import java.util.List;

import com.dev.miscelanea.miscelaneaapp.entity.Categoria;
import com.dev.miscelanea.miscelaneaapp.entity.Producto;

public interface CategoriaDAO {

	public Categoria findById(int id);
	
	public List<Categoria> findAll();
	
	public void save(Categoria categoria);
	
	public void deleteById(int id);

	public List<Producto> findProductosByIdCategoria(int id);
	
}
