package com.dev.miscelanea.miscelaneaapp.dao;

import java.util.List;

import com.dev.miscelanea.miscelaneaapp.entity.Proveedor;

public interface ProveedorDAO {

	public List<Proveedor> findAll();
	
	public Proveedor findById(int id);
	
	public void save(Proveedor proveedor);
	
	public void deleteById(int id);
	
}
