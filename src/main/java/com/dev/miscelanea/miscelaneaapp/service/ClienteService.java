package com.dev.miscelanea.miscelaneaapp.service;

import java.util.List;

import com.dev.miscelanea.miscelaneaapp.entity.Cliente;

public interface ClienteService {

	public List<Cliente> findAll();
	
	public Cliente findById(int id);
	
	public void save(Cliente cliente);
	
	public void deleteById(int id);
	
	public void deactivateById(int id);
	
}
