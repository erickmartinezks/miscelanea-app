package com.dev.miscelanea.miscelaneaapp.dao;

import java.util.List;

import com.dev.miscelanea.miscelaneaapp.entity.Cliente;

public interface ClienteDAO {

	public List<Cliente> findAll();
	
	public Cliente findById(int id);
	
	public void save(Cliente cliente);
	
	public void deleteById(int id);
	
	public void deactivateById(int id);
	
}
