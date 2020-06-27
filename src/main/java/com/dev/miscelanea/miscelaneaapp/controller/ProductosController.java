package com.dev.miscelanea.miscelaneaapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.miscelanea.miscelaneaapp.entity.Categoria;
import com.dev.miscelanea.miscelaneaapp.entity.Producto;
import com.dev.miscelanea.miscelaneaapp.service.CategoriaService;
import com.dev.miscelanea.miscelaneaapp.service.ProductoService;
import com.dev.miscelanea.miscelaneaapp.uiconstraints.UIProducto;

@Controller
@RequestMapping("/inventarios/productos")
public class ProductosController {

	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	ProductoService productoService;
	
	// OBTENER PRODUCTOS
	@GetMapping("")
	public String showProductos(Model theModel) {
		
		List<Producto> productos = productoService.findAll();
		
		theModel.addAttribute("productos", productos);
		
		return "/inventarios/productos";
	}
	
	// FORMULARIO ALTA PRODUCTO
	@GetMapping("/alta-producto")
	public String showFormForAdd(Model theModel) {
		
		List<Categoria> categorias = categoriaService.findAll();		
		
		if(categorias != null) {
			theModel.addAttribute("categorias", categorias);	
		}
		
		theModel.addAttribute("producto", new UIProducto());
		
		return "/inventarios/producto-form";
	}
	
	// ALTA PRODUCTO
	@PostMapping("/alta-producto")
	public String processAltaProducto(@Valid @ModelAttribute("producto") UIProducto tempProducto,
										BindingResult theBindingResult, Model theModel) {
		
		// form validation
		if(theBindingResult.hasErrors()) {
			// No es la mejor manera de controlar esto y no conviene obetener todo cada que hay errores en los campos...
			// por el momento se queda así porque es práctica...
			List<Categoria> categorias = categoriaService.findAll();
			if(categorias != null) {
				theModel.addAttribute("categorias", categorias);	
			}
			//
			
			return "/inventarios/producto-form";
		}
		
		if(tempProducto.getId() == 0 && productoService.findByCodigo(tempProducto.getCodigo()) != null) {
			//theBindingResult.addError(new ObjectError());
			theBindingResult.rejectValue("codigo", "error.codigo", "Ya existe un producto con ése código");
			
			List<Categoria> categorias = categoriaService.findAll();
			if(categorias != null) {
				theModel.addAttribute("categorias", categorias);	
			}
			
			return "/inventarios/producto-form";
		}
		
		productoService.save(tempProducto);
		
		return "redirect:/inventarios/productos";
	}

	// EDITAR PRODUCTO
	@GetMapping("/editar-producto")
	public String showFormForUpdate(@RequestParam("productoId") int productoId, Model theModel) {
		
		Producto tempProducto = productoService.findById(productoId);
		theModel.addAttribute("producto", tempProducto);
		
		List<Categoria> categorias = categoriaService.findAll();
		if(categorias != null) {
			theModel.addAttribute("categorias", categorias);	
		}
		
		return "/inventarios/producto-form";
	}

	// ELIMINAR PRODUCTO
	@GetMapping("/eliminar-producto")
	public String deleteProducto(@RequestParam("productoId") int productoId, Model theModel) {
		
		productoService.deleteProductoById(productoId);
		
		return "redirect:/inventarios/productos";
	}
}
