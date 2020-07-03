package com.dev.miscelanea.miscelaneaapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dev.miscelanea.miscelaneaapp.dao.ClienteDAO;
import com.dev.miscelanea.miscelaneaapp.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	ClienteDAO clienteDAO;
	
	public ClienteServiceImpl(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	@Override
	@Transactional
	public List<Cliente> findAll() {

		return clienteDAO.findAll();
	}

	@Override
	@Transactional
	public Cliente findById(int id) {

		return clienteDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {

		clienteDAO.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(int id) {

		clienteDAO.deleteById(id);
	}

	@Override
	@Transactional
	public void deactivateById(int id) {

		clienteDAO.deactivateById(id);
	}

}
