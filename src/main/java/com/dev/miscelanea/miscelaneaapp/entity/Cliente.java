package com.dev.miscelanea.miscelaneaapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Size(min = 1, message = "obligatorio")
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@Size(min = 1, message = "obligatorio")
	@Column(name = "apellidos")
	private String apellidos;
	
	@Size(min = 1, message = "obligatorio")
	@NotNull
	@Column(name = "fecha_alta")
	private String fechaAlta;
	
	@Column(name = "domicilio")
	private String domicilio;
	
	@Column(name = "activo")
	private int activo;

	public Cliente() {
		
	}
	
	public Cliente(String nombre, String apellidos, String fechaAlta, String domicilio, int activo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaAlta = fechaAlta;
		this.domicilio = domicilio;
		this.activo = activo;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaAlta=" + fechaAlta
				+ ", domicilio=" + domicilio + ", activo=" + activo + "]";
	}
	
	
	
	
}
