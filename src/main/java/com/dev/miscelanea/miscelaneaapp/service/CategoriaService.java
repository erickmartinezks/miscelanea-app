package com.dev.miscelanea.miscelaneaapp.service;

import java.util.List;

import com.dev.miscelanea.miscelaneaapp.entity.Categoria;

public interface CategoriaService {

	public void save(Categoria categoria);

	public List<Categoria> getAllCategorias();

	public void deleteById(int id);
	
}
