package com.dev.miscelanea.miscelaneaapp.dao;

import java.util.List;

import com.dev.miscelanea.miscelaneaapp.entity.Categoria;

public interface CategoriaDAO {

	public void save(Categoria categoria);
	
	public List<Categoria> getAllCategorias();
	
	public Categoria findCategoriaById(int id);
	
	public void deleteById(int id);
	
}
