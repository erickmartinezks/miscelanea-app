package com.dev.miscelanea.miscelaneaapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.miscelanea.miscelaneaapp.dao.CategoriaDAO;
import com.dev.miscelanea.miscelaneaapp.dao.ProductoDAO;
import com.dev.miscelanea.miscelaneaapp.entity.Categoria;
import com.dev.miscelanea.miscelaneaapp.entity.Producto;
import com.dev.miscelanea.miscelaneaapp.ui.UIProducto;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoDAO productoDAO;
	
	@Autowired
	CategoriaDAO categoriaDAO;
	
	@Transactional
	@Override
	public void save(UIProducto producto) {

		Producto oProducto = new Producto();
		try {
			oProducto.setId(producto.getId());
			oProducto.setNombre(producto.getNombre());
			oProducto.setDescripcion(producto.getDescripcion());
			oProducto.setPrecio(producto.getPrecio());
			oProducto.setStock(producto.getStock());
			oProducto.setCategoria(producto.getCategoria());
			//oProducto.setCategoria(categoriaDAO.findCategoriaById(Integer.parseInt(producto.getCategoriaId())));
			
			productoDAO.save(oProducto);
		
		}catch(Exception err) {
			System.out.println("ERROR::::::::" + err.getMessage());
		}
	}

	@Transactional
	@Override
	public List<Producto> findAll() {
		
		return productoDAO.findAll();
	}

	@Transactional
	@Override
	public Producto findById(int id) {
		
		return productoDAO.findById(id);
	}

	@Transactional
	@Override
	public void deleteProductoById(int id) {
		
		productoDAO.deleteProductoById(id);
	}

}
