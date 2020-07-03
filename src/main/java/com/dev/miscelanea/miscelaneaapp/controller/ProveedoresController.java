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

import com.dev.miscelanea.miscelaneaapp.entity.Proveedor;
import com.dev.miscelanea.miscelaneaapp.service.ProveedorService;

@Controller
@RequestMapping("/inventarios/proveedores")
public class ProveedoresController {

	//Otra forma de inyectar dependencias
	ProveedorService proveedorService;
	
	public ProveedoresController(ProveedorService proveedorService) {
		this.proveedorService = proveedorService;
	}
	
	// OBTENER PROVEEDORES
	@GetMapping("")
	public String showProveedores(Model theModel) {
		
		theModel.addAttribute("proveedores", proveedorService.findAll());
		
		return "/proveedores/proveedores";
	}

	// FORMULARIO ALTA <>
	@GetMapping("alta-proveedor")
	public String showFormForAdd(Model theModel) {
		
		theModel.addAttribute("proveedor", new Proveedor());
		
		return "/proveedores/proveedor-form";
	}

	// ALTA <>
	@PostMapping("alta-proveedor")
	public String processAltaProveedor(@Valid @ModelAttribute("proveedor") Proveedor tempProveedor, 
			BindingResult theBindingResult, Model theModel) {
		
		if(theBindingResult.hasErrors()) {
			return "/proveedores/proveedor-form";
		}
		
		proveedorService.save(tempProveedor);
		
		return "redirect:/inventarios/proveedores";
	}

	// EDITAR <>
	@GetMapping("/editar-proveedor")
	public String editarProveedor(@RequestParam("proveedorId") int proveedorId, Model theModel) {
		
		theModel.addAttribute("proveedor", proveedorService.findById(proveedorId));
		
		return "/proveedores/proveedor-form";
	}

	// ELIMINAR <>
	@GetMapping("/eliminar-proveedor")
	public String eliminarProveedor(@RequestParam("proveedorId") int proveedorId, Model theModel) {
		
		proveedorService.deleteById(proveedorId);
		
		return "redirect:/inventarios/proveedores";
	}
	
	
	
	
}
