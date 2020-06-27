package com.dev.miscelanea.miscelaneaapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.miscelanea.miscelaneaapp.dao.ProductoDAO;
import com.dev.miscelanea.miscelaneaapp.entity.Categoria;
import com.dev.miscelanea.miscelaneaapp.entity.Producto;
import com.dev.miscelanea.miscelaneaapp.service.CategoriaService;
import com.dev.miscelanea.miscelaneaapp.service.ProductoService;

@Controller
@RequestMapping("/inventarios/categorias")
public class CategoriasController {

	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	ProductoService productoService;
	//ProductoDAO productoDAO;
	
	// OBTENER CATEGORIAS
	@GetMapping("")
	public String showCategorias(Model theModel) {
		
		List<Categoria> categorias = categoriaService.findAll();
		categorias.remove(0); // Quitar categoria 'Sin Categoria' del listado para evitar que se edite y elimine
		
		theModel.addAttribute("categorias", categorias);
		
		return "/categorias/categorias";
	}
	
	// FORMULARIO ALTA CATEGORIA
	@GetMapping("/alta-categoria")
	public String showFormForAdd(Model theModel) {
		
		theModel.addAttribute("categoria", new Categoria());
		
		return "/categorias/categoria-form";
	}
	
	// ALTA CATEGORIA
	@PostMapping("/alta-categoria")
	public String processAltaCategoria(@Valid @ModelAttribute("categoria") Categoria tempCategoria,
			BindingResult theBindingResult, Model theModel) {
		
		if(theBindingResult.hasErrors()) {
			return "/categorias/categoria-form";
		}

		categoriaService.save(tempCategoria);
		
		return "redirect:/inventarios/categorias";
	}
	
	// EDITAR CATEGORIA
	@GetMapping("/editar-categoria")
	public String editarCategoria(@RequestParam("categoriaId") int categoriaId,
			Model theModel) {
		
		if(categoriaId == 1) {
			
			return "redirect:/inventarios/categorias";
			
		}
		
		Categoria tempCategoria = categoriaService.findById(categoriaId);
		theModel.addAttribute("categoria", tempCategoria);
		
		return "/categorias/categoria-form";
	}
	
	// ELIMINAR CATEGORIA
	@GetMapping("/eliminar-categoria")
	public String eliminarCategoria(@RequestParam("categoriaId") int id, Model theModel) {

		if(id == 1) {
			return "redirect:/inventarios/categorias";
		}
		
		List<Producto> productos = categoriaService.findProductosByIdCategoria(id);

		if(productos != null) {
			
			Categoria tempCategoria = categoriaService.findById(1);

			for(Producto tempProducto : productos) {
				tempProducto.setCategoria(tempCategoria);
				productoService.save(tempProducto);
			}
			
		}
		
		categoriaService.deleteById(id);
		
		return "redirect:/inventarios/categorias";
	}

	
	
	
	
	
	
	
	
	
}
