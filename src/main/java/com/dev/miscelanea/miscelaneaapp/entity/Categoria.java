package com.dev.miscelanea.miscelaneaapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Size(min=1, message="obligatorio")
	@NotNull
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REFRESH) // mappedBy = "<Nombre de variable en clase Producto>"
	private List<Producto> productos;

	public Categoria() {
		
	}
	
	public Categoria(String nombre, String descripcion, List<Producto> productos) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.productos = productos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	// add convenience methods for bidirectional relationship
	public void add(Producto tempProducto) {
		if(productos == null) {
			productos = new ArrayList<>();
		}
		
		productos.add(tempProducto);
		
		tempProducto.setCategoria(this);
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", productos="
				+ productos + "]";
	}

	

	
	

}
