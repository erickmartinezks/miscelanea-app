package com.dev.miscelanea.miscelaneaapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dev.miscelanea.miscelaneaapp.dao.ProveedorDAO;
import com.dev.miscelanea.miscelaneaapp.entity.Proveedor;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	// Inyeccion de dependencias por constructor (solo para hacer uso de ambas formas y ver que funcionan)
	ProveedorDAO proveedorDAO;
	
	public ProveedorServiceImpl(ProveedorDAO proveedorDAO) {
		this.proveedorDAO = proveedorDAO;
	}
	
	@Override
	@Transactional
	public List<Proveedor> findAll() {

		return proveedorDAO.findAll();
	}

	@Override
	@Transactional
	public Proveedor findById(int id) {

		return proveedorDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Proveedor proveedor) {

		proveedorDAO.save(proveedor);
	}

	@Override
	@Transactional
	public void deleteById(int id) {

		proveedorDAO.deleteById(id);
	}

}
