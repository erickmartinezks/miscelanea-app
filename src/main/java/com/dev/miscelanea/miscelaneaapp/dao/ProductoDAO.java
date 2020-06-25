package com.dev.miscelanea.miscelaneaapp.dao;

import java.util.List;

import com.dev.miscelanea.miscelaneaapp.entity.Producto;

public interface ProductoDAO {

	public List<Producto> findAll();
	
	public Producto findById(int id);
	
	public void save(Producto producto);
	
	public void deleteProductoById(int id);
}
