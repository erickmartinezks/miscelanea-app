package com.dev.miscelanea.miscelaneaapp.service;

import java.util.List;

import com.dev.miscelanea.miscelaneaapp.entity.Producto;
import com.dev.miscelanea.miscelaneaapp.ui.UIProducto;

public interface ProductoService {

	public List<Producto> findAll();
	
	public Producto findById(int id);
	
	public void save(UIProducto producto);
	
	public void deleteProductoById(int id);
	
}
