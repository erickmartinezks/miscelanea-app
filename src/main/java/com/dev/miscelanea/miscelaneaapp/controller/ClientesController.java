package com.dev.miscelanea.miscelaneaapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.miscelanea.miscelaneaapp.entity.Cliente;
import com.dev.miscelanea.miscelaneaapp.service.ClienteService;

@Controller
@RequestMapping("/inventarios/clientes")
public class ClientesController {

	ClienteService clienteService;
	
	public ClientesController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	// OBTENER <>
	@GetMapping("")
	public String showClientes(Model theModel) {
		
		theModel.addAttribute("clientes", clienteService.findAll());
		
		return "/clientes/clientes";
	}

	// FORMULARIO ALTA <>
	@GetMapping("/alta-cliente")
	public String showFormForAdd(Model theModel) {
		
		theModel.addAttribute("cliente", new Cliente());
		
		return "/clientes/cliente-form";
	}

	// ALTA <>
	@PostMapping("/alta-cliente")
	public String processAltaCliente(@Valid @ModelAttribute("cliente") Cliente cliente, 
										BindingResult theBindingResult, Model theModel) {
		
		if(theBindingResult.hasErrors()) {
			return "/clientes/cliente-form";
		}
		
		clienteService.save(cliente);
		
		return "redirect:/inventarios/clientes";
	}

	// EDITAR <>
	@GetMapping("/editar-cliente")
	public String showFormForUpdate(@RequestParam("clienteId") int clienteId, Model theModel) {
		
		theModel.addAttribute("cliente", clienteService.findById(clienteId));
		
		return "/clientes/cliente-form";
	}

	// ELIMINAR <>
	@GetMapping("/eliminar-cliente")
	public String delete(@RequestParam("clienteId") int clienteId) {
		
		//clienteService.deleteById(clienteId);
		clienteService.deactivateById(clienteId);
		
		return "redirect:/inventarios/clientes";
	}
	
	
}
