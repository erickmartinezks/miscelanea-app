package com.dev.miscelanea.miscelaneaapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Size(min = 1, message = "obligatorio")
	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "telefono")
	private String telefono;

	public Proveedor() {
		
	}
	
	public Proveedor(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
}
