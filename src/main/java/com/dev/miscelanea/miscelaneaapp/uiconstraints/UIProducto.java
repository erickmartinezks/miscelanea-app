package com.dev.miscelanea.miscelaneaapp.uiconstraints;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dev.miscelanea.miscelaneaapp.entity.Categoria;

public class UIProducto {

	private int id;
	
	@NotNull
	@Size(min = 1, max = 20, message = "Obligatorio")
	private String codigo;
	
	@NotNull
	@Size(min = 1, message = "Obligatorio")
	private String nombre;
	
	private String descripcion;
	
	@NotNull
	@DecimalMin(value = "0", message = "El valor debe ser igual o mayor a 0")
	private String precio;
	
	@NotNull
	@DecimalMin(value = "0", message = "El valor debe ser igual o mayor a 0")
	private String stock;
	
	//private String categoriaId;
	@NotNull
	private Categoria categoria;
	
	public UIProducto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "UIProducto [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock="
				+ stock + ", categoria=" + categoria + "]";
	}
	
	
	/*
	public String getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(String categoriaId) {
		this.categoriaId = categoriaId;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock
				+ ", categoriaId=" + categoriaId + "]";
	}
	*/
	
	
}
